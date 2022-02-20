package com.example.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.Question;
import com.example.domain.Resident;
import com.example.domain.Response;
import com.example.repo.OptionRepository;
import com.example.repo.QuestionRepository;
import com.example.repo.ResidentRepository;
import com.example.repo.ResponseRepository;
import com.example.repo.UserRepository;

@Controller
@RequestMapping("/resident")
public class ResidentController {

	@Autowired
	ResidentRepository repoR;
	
	@Autowired
	QuestionRepository repoQ;
	
	@Autowired
	UserRepository repoU;
	
	@Autowired
	ResponseRepository repoRes;
	
	@Autowired
	OptionRepository repoO;
	
	@Autowired
	PasswordEncoder pe;
	
	@GetMapping(value="")
	public String residentDash(Model model, Principal principal) {
		Resident resident = repoR.findByUserid(principal.getName());
		model.addAttribute("user", resident.getUserid());
		return "resident/dashboard";
	}
	
	@GetMapping("/viewQuestions")
	public String viewQuestions(Model model, Principal principal) {
		Resident resident = repoR.findByUserid(principal.getName());
		model.addAttribute("user", resident.getUserid());
		List<Question> questions = repoQ.findAll();
		List<Response> responses = repoRes.findAll();
		List<Integer> answered = new ArrayList<>();
		List<Question> notHidden = new ArrayList<>();
		for (Question q : questions) {
			if(q.getHiddenFromResident() == false) {
				notHidden.add(q);
			}
		}
	    model.addAttribute("userID", resident.getSni());
	    for(Response r : responses) {
	    	if(r.getUser().getSni() == resident.getSni()) {
	    	 model.addAttribute("userCheck", r.getUser().getSni());
	    	}
	    }
	    for (Response e : responses) {
	    	if(e.getUser().getSni() == resident.getSni()) {
	    	for(Question a : questions) {
	    	if(e.getQuestion().getID() == a.getID()) {
	    		answered.add(e.getQuestion().getID());
	    	}
	    	}
	    	}
	    }
	    model.addAttribute("questions", notHidden);
    	model.addAttribute("questionCheck1", answered);
		return "resident/viewQuestions";
	}
	
	@GetMapping("/answerQuestion")
	public String answerQuestion(@ModelAttribute("response") Response response, @RequestParam int question, Model model, Principal principal) {
		Resident resident = repoR.findByUserid(principal.getName());
		model.addAttribute("user", resident.getUserid());
		Question targetQuestion = repoQ.findByID(question);
		model.addAttribute("options", targetQuestion.getOptions());
	    model.addAttribute("questionID", targetQuestion.getID());
	    model.addAttribute("userID", resident.getSni());
		return "resident/answerQuestion";
	}
	
	@PostMapping("/answeredQuestion")
	public String answeredQuestion(@ModelAttribute("response") Response response, @RequestParam int question, Model model, Principal principal) {
		Resident resident = repoR.findByUserid(principal.getName());
		model.addAttribute("user", resident.getUserid());
		Question targetQuestion = repoQ.findByID(question);
	    model.addAttribute("questionID", targetQuestion.getID());
	    model.addAttribute("userID", resident.getSni());
		repoRes.save(response);
		return "redirect:/resident/viewQuestions";
	}
}
