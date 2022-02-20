package com.example.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.Option;
import com.example.domain.Question;
import com.example.domain.Resident;
import com.example.domain.Response;
import com.example.domain.User;
import com.example.repo.AdminRepository;
import com.example.repo.OptionRepository;
import com.example.repo.QuestionRepository;
import com.example.repo.ResidentRepository;
import com.example.repo.ResponseRepository;
import com.example.repo.UserRepository;
import com.google.gson.Gson;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminRepository repoA;
	
	@Autowired
	UserRepository repoU;
	
	@Autowired
	ResidentRepository repoR;
	
	@Autowired
	QuestionRepository repoQ;
	
	@Autowired
	OptionRepository repoO;
	
	@Autowired
	ResponseRepository repoRes;
	
	@GetMapping(value="")
	public String adminDash(Model model, Principal principal) {
		User admin = repoU.findByUserid(principal.getName());
		model.addAttribute("user", admin.getUserid());
		return "admin/dashboard";
	}
	@GetMapping(value="/newResidentInformation")
	public String newResidentInfo(Model model, Principal principal) {
		User admin = repoU.findByUserid(principal.getName());
		model.addAttribute("user", admin.getUserid());
		model.addAttribute("newResidentInfo", new Resident());
		return "admin/addResidentInfo";
	}
	
	@PostMapping(value="/addResidentInformation")
	public String addResidentInfo(@ModelAttribute ("newResidentInfo") Resident information, @RequestParam("sni") String sni, Principal principal, Model model) {
	User admin = repoU.findByUserid(principal.getName());
	model.addAttribute("user", admin.getUserid());
	Resident resident = repoR.findBySni(sni);
	if (resident != null) {
		model.addAttribute("userError", "The Shangri-La National Insurance Number " + sni + " is already being used");
		return "admin/addResidentInfo";
	}
	repoR.save(information);
	return "redirect:/";
	}
	
	@GetMapping("/newQuestion")
	public String createQuestion(Model model, Principal principal) {
		User admin = repoU.findByUserid(principal.getName());
		model.addAttribute("user", admin.getUserid());
		model.addAttribute("question", new Question());
		return "admin/createQuestion";
	}
	
	@PostMapping("/addQuestion")
	public String newQuestion(@ModelAttribute Question question, Model model, Principal principal) {
		User admin = repoU.findByUserid(principal.getName());
		model.addAttribute("user", admin.getUserid());
		question.setHiddenFromResident(false);
		repoQ.save(question);
		return "redirect:/";
	}
	
	@GetMapping("/viewQuestions")
	public String question(Model model, Principal principal) {
		User admin = repoU.findByUserid(principal.getName());
		model.addAttribute("user", admin.getUserid());
		List<Question> questions = repoQ.findAll();
		List<Response> responses = repoRes.findAll();
		List<Integer> answered = new ArrayList<>();
		model.addAttribute("questions", questions);
		for(Response r : responses) {
			for(Question q : questions) {
				if(r.getQuestion().getID() == q.getID()) {
					answered.add(r.getQuestion().getID());
				}
			}
		}
		model.addAttribute("questionCheck1", answered);
		return "admin/viewQuestions";
	}
	
	@GetMapping("/newOption")
	public String createOption(@RequestParam int question, Model model, Principal principal) {
		User admin = repoU.findByUserid(principal.getName());
		model.addAttribute("user", admin.getUserid());
		model.addAttribute("questionID", question);
		model.addAttribute("option", new Option());
		return "admin/createOption";
	}
	
	@PostMapping("/addOption")
	public String newOption(@ModelAttribute Option questionOption, @RequestParam int question, @RequestParam("questionOption") String option, Model model, Principal principal) {
		User admin = repoU.findByUserid(principal.getName());
		model.addAttribute("user", admin.getUserid());
		model.addAttribute("questionID", question);
		List<Option> options = repoO.findAll();
			for (Option o : options) {
				if(o.getQuestion().getID() == question) {
					if(o.getQuestionOption().equals(option)) {
						model.addAttribute("userError", "The option '" + option + "' for the question '" + o.getQuestion().getTitle() + "' already exists");
						return "admin/createOption";
					}
				}
			}
		repoO.save(questionOption);
		return "redirect:/admin/viewOptions?question="+question;
		}
	
	@GetMapping("/editQuestion")
	public String editQuestion(@ModelAttribute Question ques, @RequestParam int question, Model model, Principal principal) {
		User admin = repoU.findByUserid(principal.getName());
		model.addAttribute("user", admin.getUserid());
		model.addAttribute("questionID", question);
		model.addAttribute("title", ques.getTitle());
		return "admin/editQuestion";
	}
	
	@PostMapping("/editedQuestion")
	public String editedQuestion(@ModelAttribute Question ques, @RequestParam int question, Model model, Principal principal) {
		User admin = repoU.findByUserid(principal.getName());
		model.addAttribute("user", admin.getUserid());
		model.addAttribute("questionID", question);
		repoQ.save(ques);
		return "redirect:/admin/viewQuestions";
	}
	
	@GetMapping("/viewOptions")
	public String viewOptions(@RequestParam int question, Model model, Principal principal) {
		User admin = repoU.findByUserid(principal.getName());
		model.addAttribute("user", admin.getUserid());
		Question targetQuestion = repoQ.findByID(question);
		model.addAttribute("options", targetQuestion.getOptions());
		model.addAttribute("questionID", targetQuestion.getID());
		return "admin/viewOptions";
	}
	
	@GetMapping("/editOption")
	public String editOption(@ModelAttribute Option option, Model model, Principal principal) {
		User admin = repoU.findByUserid(principal.getName());
		model.addAttribute("user", admin.getUserid());
		model.addAttribute("questionOption", option.getQuestionOption());
		return "admin/editOption";
		}
	
	@PostMapping("/editedOption")
	public String editedOption(@ModelAttribute Option option, @RequestParam("question") int question, Model model, Principal principal) {
		User admin = repoU.findByUserid(principal.getName());
		model.addAttribute("user", admin.getUserid());
		model.addAttribute("questionID", question);
		repoO.save(option);
		return "redirect:/admin/viewOptions?question=" + question;
	}
	@RequestMapping("/removeOption")
	public String removeOption(@RequestParam int question, @RequestParam int option, Model model, Principal principal) {
		Option opt = repoO.findById(option);
		repoO.delete(opt);
		return "redirect:/admin/viewOptions?question="+question;
	}
	@RequestMapping("/removeQuestion")
	public String removeQuestion(@RequestParam int question) {
		List<Option> options = repoO.findAll();
		Question targetQuestion = repoQ.findByID(question);
		List<Response> responses = repoRes.findAll();
		List<Response> responseToDelete = new ArrayList<>();
		List<Option> toDelete = new ArrayList<>();
		for (Option o : options) {
			if (o.getQuestion() == targetQuestion) {
				toDelete.add(o);
				for (Response r : responses) {
					if(r.getQuestion().getID() == targetQuestion.getID()) {
						responseToDelete.add(r);
					}
				}
			}
		}
		repoRes.deleteAll(responseToDelete);
		repoO.deleteAll(toDelete);
		repoQ.delete(targetQuestion);
		return "redirect:/admin/viewQuestions";
	}
	@RequestMapping("/hideQuestion")
	public String hideQuestion(@RequestParam int question) {
		Question targetQuestion = repoQ.findByID(question);
		targetQuestion.setHiddenFromResident(true);
		repoQ.save(targetQuestion);
		return "redirect:/admin/viewQuestions";
	}
	
	@RequestMapping("/showQuestion")
	public String showQuestion(@RequestParam int question) {
		Question targetQuestion = repoQ.findByID(question);
		targetQuestion.setHiddenFromResident(false);
		repoQ.save(targetQuestion);
		return "redirect:/admin/viewQuestions";
	}
	@GetMapping("/viewResults")
	public String viewResults(@RequestParam int question, Model model, Principal principal) {
		User admin = repoU.findByUserid(principal.getName());
		model.addAttribute("user", admin.getUserid());
		List<Question> questions = repoQ.findAll();
		List<Question> targetQuestion = new ArrayList<>();
		List<Option> options = repoO.findAll();
		List<String> targetOption = new ArrayList<>();
		List<Response> responses = repoRes.findAll();
		Map<String, Number> hmap = new HashMap<String, Number>();
		Map<String, String> addMap = new HashMap<String, String>();
		int count1 = 0;
		for(Question q : questions) {
			if(q.getID() == question) {
				targetQuestion.add(q);
				for(Option o : options) {
					if(o.getQuestion().getID() == question) {
						targetOption.add(o.getQuestionOption());
						hmap.put(o.getQuestionOption(), 0);
					}
					int count = 0;
					for(Response r : responses) {
						if(r.getQuestionResponse().getQuestion().getID() == question) {
							if(r.getQuestionResponse().getId() == o.getId() && r.getQuestionResponse().getQuestionOption() == o.getQuestionOption()) {
								hmap.put(o.getQuestionOption(), count+=1);
								count1+=1;
							}
						}
					}
				}
			}
		}
		for(Response re : responses) {
			if(re.getUser() != null) {
				for(Question qs : questions) {
					if(re.getQuestion().getID() == question) {
						if(qs.getID() == question) {
							addMap.put(re.getUser().getAddress().getLatitude(), re.getUser().getAddress().getLongitude());
					}
					}
				}
			}
		}
		String jsonString = new Gson().toJson(hmap);
		String jsonString1 = new Gson().toJson(addMap);
		System.out.println(jsonString1);
		model.addAttribute("countRes", count1);
		model.addAttribute("countNum", jsonString);
		model.addAttribute("optionID", targetOption);
		model.addAttribute("questions", targetQuestion);
		model.addAttribute("options", options);
		model.addAttribute("longlat", jsonString1);
		return "admin/viewResults";
	}
	}
