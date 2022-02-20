package com.example.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.Admin;
import com.example.domain.Circumstance;
import com.example.domain.Convenor;
import com.example.domain.Groupwork;
import com.example.domain.LivesWithCircumstance;
import com.example.domain.OtherCircumstance;
import com.example.domain.ResetRequest;
import com.example.domain.Selection;
import com.example.domain.Student;
import com.example.domain.StudentGroup;
import com.example.repository.AdminRepository;
import com.example.repository.ConvenorRepository;
import com.example.repository.GroupworkRepository;
import com.example.repository.LivesWithCircumstanceRepository;
import com.example.repository.OtherCircumstanceRepository;
import com.example.repository.ProjectRepository;
import com.example.repository.ResetRequestRepository;
import com.example.repository.SelectionRepository;
import com.example.repository.StudentGroupRepository;
import com.example.repository.StudentRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private PasswordEncoder pe;
	
	@Autowired
	private AdminRepository repo;
	
	@Autowired
	private ConvenorRepository repoC;
	
	@Autowired
	private StudentRepository srepo;

	@Autowired
	private GroupworkRepository repoG;

	@Autowired
	private ProjectRepository repoP;

	@Autowired
	private OtherCircumstanceRepository ocrepo;
	
	@Autowired
	private LivesWithCircumstanceRepository lwcrepo;

	@Autowired
	private StudentGroupRepository repoS;
	
	@Autowired
	private SelectionRepository repoSelect;
	
	@Autowired
	private ResetRequestRepository repoReset;
	
	@RequestMapping(value = "", method= RequestMethod.GET)
	public String adminMenu(Model model, Principal principal) {
	Admin u = repo.findByUsername(principal.getName());
	model.addAttribute("user", u.getName());
	return "admin/menu";
	}
	
	@RequestMapping(value = "/newConvenor", method = RequestMethod.GET)
	public String newConvenor(Model model, Principal principal) {
		Admin u = repo.findByUsername(principal.getName());
		model.addAttribute("user", u.getName());
		model.addAttribute("convenor", new Convenor());
		return "admin/createAccount";
	}
	
	@RequestMapping(value = "/addConvenor", method = RequestMethod.POST)
	public String createConvenor(@ModelAttribute Convenor convenor, Principal principal) {
		
		 convenor.setPassword(pe.encode(convenor.getPassword()));
	        repoC.save(convenor);
		return "redirect:/admin/convenors";
	}
	
	@RequestMapping(value = "/convenors", method = RequestMethod.GET)
	public String convenors(Model model, Principal principal) {
		Admin u = repo.findByUsername(principal.getName());
		List<Convenor> convenors = repoC.findAll();
		model.addAttribute("convenors", convenors);
		model.addAttribute("user", u.getName());

		return "admin/convenors";
	}
	
	@RequestMapping(value = "/removeConvenor")
	public String removeConvenor(@RequestParam String username, Principal principal) {
		Convenor convenor = repoC.findByUsername(username);
		List<Groupwork> groupworks = repoG.findAll();
		List<Groupwork> groupworksToDelete = new ArrayList<>();
		
		List<Selection> selections = repoSelect.findAll();
		List<Student> students = srepo.findAll();
		
		
		//find all groupworks the convenor authors
		for(Groupwork g : groupworks) {
			if(g.getAuthor() == convenor) {
				groupworksToDelete.add(g);
			}
		}
		
		//delete selections for those groupworks
		List<Selection> toDelete1 = new ArrayList<>();
		for(Selection s : selections) {
			for(Groupwork g : groupworksToDelete) {
				if(s.getGroupwork() == g) {
					toDelete1.add(s);
				}
			}
		}
		
		if(!toDelete1.isEmpty()) {
			List<Selection> toDelete2 = new ArrayList<>();
			for(Student s : students) {
				for(Selection select : s.getSelections()) {
					if(toDelete1.contains(select)) {
						toDelete2.add(select);
					}
				}
				if(!toDelete2.isEmpty()) {
					s.getSelections().removeAll(toDelete2);
				}
				srepo.save(s);
			}
			repoSelect.deleteAll(toDelete1);
		}

		//delete groupworks
		if(!groupworksToDelete.isEmpty()) {
			repoG.deleteAll(groupworksToDelete);
		}
		
		//deleteResetRequest
		ResetRequest r = null;
		if(repoReset.findByRequester(convenor) != null) {
			r = repoReset.findByRequester(convenor);
			repoReset.delete(r);
		}
		
		//delete roles from convenor
		convenor.getRoles().clear();
		
	    repoC.delete(convenor);
		return "redirect:/admin/convenors";
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String students(Model model, Principal principal) {
		Admin u = repo.findByUsername(principal.getName()); 
		List<Student> students = srepo.findAll();
		model.addAttribute("students", students);
		model.addAttribute("user", u.getName());

		return "admin/students";
	}
	
	@RequestMapping(value = "/removeStudent")
	public String removeStudents(@RequestParam String username, Principal principal) {
		Student student = srepo.findByUsername(username);
		List<Groupwork> groupworks = repoG.findAll();
		
		//delete from studentgroups
		List<StudentGroup> studentGroups = repoS.findAll();
		boolean remove = false;
		for(StudentGroup sg : studentGroups) {
			for(Student s : sg.getStudentList()) {
				if(s == student) {
					remove = true;
				}
			}
			if(remove) {
				sg.getStudentList().remove(student);
			}
		}
		
		
		//delete student from groupwork
		List<Groupwork> groupworksToChange = new ArrayList<>();
		for(Groupwork g : groupworks) {
			for(Student s : g.getStudents()) {
				if(s == student) {
					groupworksToChange.add(g);
				}
			}
			for(Student s : g.getUnassignedStudents()) {
				if(s == student) {
					groupworksToChange.add(g);
				}
			}
		}
		
		for(Groupwork g : groupworksToChange) {
			g.getStudents().remove(student);
			g.getUnassignedStudents().remove(student);

		}
		
		//remove circumstances from the groupwork
		List<OtherCircumstance> toRemoveOther = new ArrayList<>();
		List<LivesWithCircumstance> toRemoveLives = new ArrayList<>();
		List<LivesWithCircumstance> livesWithCirc = lwcrepo.findAll();
		for(Groupwork g : groupworks) {
			for(Circumstance c : g.getCircumstances()) {
				if(c.getThisStudent() == student) {
					
					if (c instanceof LivesWithCircumstance) {
						toRemoveLives.add((LivesWithCircumstance) c);
					}
					else {
						toRemoveOther.add((OtherCircumstance) c);
					}
				}
				if(c instanceof LivesWithCircumstance) {
					if(((LivesWithCircumstance) c).getOtherStudent() == student && !toRemoveLives.contains(c)) {
						toRemoveLives.add((LivesWithCircumstance) c);
					}
				}
			}

			g.getCircumstances().removeAll(toRemoveLives);
			g.getCircumstances().removeAll(toRemoveOther);
			repoG.save(g);
		}
		
		//delete circumstances
		if(!toRemoveLives.isEmpty()) {
			lwcrepo.deleteAll(toRemoveLives);
		}
		if(!toRemoveOther.isEmpty()) {
			ocrepo.deleteAll(toRemoveOther);
		}
		
		//deleteResetRequest
		ResetRequest r = null;
		if(repoReset.findByRequester(student) != null) {
			r = repoReset.findByRequester(student);
			repoReset.delete(r);
		}

		//delete roles from convenor
		student.getRoles().clear();
		
	    srepo.delete(student);
		return "redirect:/admin/students";
	}
}
