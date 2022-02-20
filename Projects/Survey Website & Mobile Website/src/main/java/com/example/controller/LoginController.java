package com.example.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.Resident;
import com.example.domain.Role;
import com.example.domain.User;
import com.example.repo.AdminRepository;
import com.example.repo.ResidentRepository;
import com.example.repo.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	UserRepository repoU;
	
	@Autowired
	ResidentRepository repoR;
	
	@Autowired
	PasswordEncoder pe;
	
	@Autowired
	AdminRepository repoA;
	
	@GetMapping(value="/")
	public String start(Model model, Principal principal) {
		User user = repoU.findByUserid(principal.getName());
		String roles = "";
		
		for(Role role : user.getRoles()) {
			roles+= role.getName() + " ";
		}
		if (roles.contains("ADMIN")) {
			return "redirect:/admin";
		}else if(roles.contains("RESIDENT")) {
			return "redirect:/resident";
		}else {
			return "start";
		}
	}
	
	@GetMapping(value ="/login-form")
	public String loginForm(){ 
		return "security/login";
	}
	
	@GetMapping(value = "/error-login")
	public String loginError(Model model) {
		model.addAttribute("error", "Invalid username and/or password");
		return "security/login";
	}
	
	@GetMapping(value="/success-login")
	public String successfulLogin(Principal principal) {
		User user = repoU.findByUserid(principal.getName());
		if (user.getRoles().isEmpty()) {
			return "security/deny";
		}
		return "redirect:/";
	}
	
	@GetMapping(value = "/denied")
	public String deny() {
		return "security/deny";
	}
	
	@GetMapping(value="/createAccount")
	public String createAccount() {
		return "security/createAccount";
	}
	
	@GetMapping(value="/newResident")
	public String newResident(Model model, Principal principal) {
	model.addAttribute("resident", new Resident());
	return "security/createAccount";
	}
	
	@PostMapping(value="/addResident")
	public String createResident(@ModelAttribute Resident resident, @RequestParam("userid") String userId, @RequestParam("sni") String sni, @RequestParam("fullName") String name, Model model, Principal principal) {
		Resident res = repoR.findBySni(sni);
		Resident resName = repoR.findByFullName(name);
		Resident resUserID = repoR.findByUserid(userId);
		List<Resident> residents = repoR.findAll();
		for(Resident r : residents) {
		if (resUserID != null) {
			model.addAttribute("userError", "The user ID " + userId + " has already been registered");
			return "security/createAccount";
		}if(r.getFullName().equals(name)) {
				if(r.getSni().equals(sni)) {
					if(r.getUserid() == null) {
					resident.setPassword(pe.encode(resident.getPassword()));
					repoR.save(resident);
					return "redirect:/login";
				}
				}
			}
		}if(res == null && resName == null) {
			model.addAttribute("userError", "The Shangri-La National Insurance Number " + sni + " and the name " + name + " doesn't match user or doesn't exist");
			return "security/createAccount";
		}else if (resName == null) {
			model.addAttribute("userError", "The name " + name + " doesn't match user or doesn't exist");
			return "security/createAccount";
		}else if (res != null) {
			model.addAttribute("userError", "The Shangri-La National Insurance Number " + sni + " is matched to another user");
			return "security/createAccount";
		}else {
			model.addAttribute("userError", "The Shangri-La National Insurance Number " + sni + " doesn't match user or doesn't exist");
			return "security/createAccount";
		}
	}
	
}
