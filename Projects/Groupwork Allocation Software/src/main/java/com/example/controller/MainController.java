package com.example.controller;

import java.io.IOException;
import java.security.Principal;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.ResetRequest;
import com.example.domain.Role;
import com.example.domain.Student;
import com.example.domain.User;
import com.example.repository.ResetRequestRepository;
import com.example.repository.UserRepository;


@Controller
public class MainController {

	@Autowired
	UserRepository repoS;
	
	@Autowired
	private PasswordEncoder pe;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String start(Model model, Principal principal) {
		User u = repoS.findByUsername(principal.getName());
		String roles = "";
		
		for(Role role : u.getRoles()) {
			roles+= role.getName() + " ";
		}
		
		if (roles.contains("CONVENOR")) {
			return "redirect:/convenor";
		}else if(roles.contains("STUDENT")) {
			return "redirect:/student";
		}else if (roles.contains("ADMIN")) {
			return "redirect:/admin";
		}else {
			return "start";
		}
	}

	@RequestMapping(value = "/login-form", method = RequestMethod.GET)
	public String loginForm() {
		return "security/login";
	}

	@RequestMapping(value = "/error-login", method = RequestMethod.GET)
	public String invalidLogin(Model model) {
		model.addAttribute("error", "Username or Password is incorrect! Please try again.");
		return "security/login";
	}

	@RequestMapping(value = "/success-login", method = RequestMethod.GET)
	public String successLogin(Principal principal) {
		User user = repoS.findByUsername(principal.getName());
		
		if (user.getRoles().isEmpty()) {
			return "security/denied";
		}
		
		return "redirect:/";
	}

	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public String error() {
		return "security/denied";
	}
	
	@RequestMapping("/testEmail") //Temporary for test emails
	@ResponseBody
	public String testEmail() throws AddressException, MessagingException, IOException {
		//EmailSystem e = new EmailSystem();
		//e.sendEmail();
		return "email sent";
	}
	
	@RequestMapping(value = "/account-settings", method = RequestMethod.GET)
	public String accountSettings(Principal principal, Model model) {
		User user = repoS.findByUsername(principal.getName());
		model.addAttribute("user", user.getName());
		model.addAttribute("email", user.getEmail());
		return "accountsettings";
	}
	
	@RequestMapping(value = "/changeEmail", method = RequestMethod.POST) 
	public String changeEmail(Principal p, @RequestParam("email1") String email1, @RequestParam("email2") String email2, Model model) {
		User user = repoS.findByUsername(p.getName());
		
		// Emails are different 
		if (!email1.equals(email2)) {
			model.addAttribute("user", user.getUsername());
			model.addAttribute("email", user.getEmail());
			model.addAttribute("emailerrors", "Emails must be the same.");
			return "accountsettings";
		}
		
		// If email already is taken
		if (repoS.findByEmail(email1) != null) {
			model.addAttribute("user", user.getUsername());
			model.addAttribute("email", user.getEmail());
			model.addAttribute("emailerrors", "Emails is already taken");
			return "accountsettings";
		}
		
		user.setEmail(email1);
		repoS.save(user);
		
		return "redirect:/account-settings";
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST) 
	public String changePassword(Principal p, @RequestParam("pass1") String pass1, @RequestParam("pass2") String pass2, Model model) {
		User user = repoS.findByUsername(p.getName());
		
		// Passwords are different 
		if (!pass1.equals(pass2)) {
			model.addAttribute("user", user.getUsername());
			model.addAttribute("email", user.getEmail());
			model.addAttribute("passerrors", "Passwords must be the same.");
			return "accountsettings";
		}
		
		user.setPassword(pe.encode(pass1));
		repoS.save(user);
		
		return "redirect:/account-settings";
	}
	
	@RequestMapping(value = "/forgotten", method = RequestMethod.GET)
	public String forgotten() {
		return "security/forgotten";
	}
	
	@Autowired
	ResetRequestRepository resetRepo;
	
	@RequestMapping(value = "/requestPasswordReset", method = RequestMethod.POST) 
	public String reqPass(@RequestParam("username") String username, Model model) throws AddressException, MessagingException, IOException {
		User user = repoS.findByUsername(username);
		
		if (user == null) {
			model.addAttribute("response", "No account with this username exists.");
			return "security/forgotten";
		}
		
		// If they already have a reset request, remove it.
		ResetRequest r = resetRepo.findByRequester(user);
		if (r != null) {
			resetRepo.delete(r);
		}
		
		ResetRequest newRequest = new ResetRequest(user);
		resetRepo.save(newRequest);
		
		com.example.Lab1S2ExAApplication.emailSystem.sendEmail(user.getEmail(), 
		"Password Reset",
		"<p>Click this link to reset your password: <a href=\"https://localhost:8443/resetPassword?key=" + newRequest.getRequestKey() + "\"> Reset </a></p>"
		);
		
		return "security/forgottenSuccess";
	}
	
	@RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
	public String resetPass(@RequestParam("key") String key, Model model) {
		ResetRequest r = resetRepo.findByRequestKey(key != null ? key : "");
		
		if (r == null) {
			return "redirect:/access-denied";
		}
		
		model.addAttribute("reqkey", key);
		return "security/passwordReset";
	}
	
	@RequestMapping(value = "/performPasswordReset", method = RequestMethod.POST) 
	public String performReset(@RequestParam String pass1, @RequestParam String pass2, @RequestParam String key, Model model) {
		ResetRequest r = resetRepo.findByRequestKey(key != null ? key : "");
		
		if (r == null) {
			return "redirect:/access-denied";
		}
		
		if (!pass1.equals(pass2)) {
			model.addAttribute("response", "The passwords must match.");
			model.addAttribute("reqkey", key);
			return "security/passwordReset";
		}
		
		r.getRequester().setPassword(pe.encode(pass1));
		repoS.save(r.getRequester());
		resetRepo.delete(r);
		
		return "security/resetSuccess";
	}
	
	@RequestMapping(value = "/groupworks", method = RequestMethod.GET)
	public String groupworksRedirect(Principal principal) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		for (GrantedAuthority x : auth.getAuthorities()) {
			if (x.getAuthority().equals("ROLE_STUDENT")) {
				System.out.println("Student");
				return "redirect:student/groupworks";
			}
			else if (x.getAuthority().equals("ROLE_CONVENOR")) {
				System.out.println("Convenor");
				return "redirect:convenor/groupworks";
			}
		}
		return "error";
	}
}
