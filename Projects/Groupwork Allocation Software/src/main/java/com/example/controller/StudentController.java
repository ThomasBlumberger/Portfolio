package com.example.controller;

import java.security.Principal;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.LivesWithCircumstance;
import com.example.domain.OtherCircumstance;
import com.example.domain.Circumstance;
import com.example.domain.Groupwork;
import com.example.domain.Project;
import com.example.domain.Selection;
import com.example.domain.Student;
import com.example.domain.StudentGroup;
import com.example.repository.CircumstanceBaseRepository;
import com.example.repository.GroupworkRepository;
import com.example.repository.LivesWithCircumstanceRepository;
import com.example.repository.OtherCircumstanceRepository;
import com.example.repository.ProjectRepository;
import com.example.repository.SelectionRepository;
import com.example.repository.StudentGroupRepository;
import com.example.repository.StudentRepository;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentRepository srepo;
	
	@Autowired
	GroupworkRepository repoG;
	
	@Autowired
	OtherCircumstanceRepository ocrepo;
	
	@Autowired
	LivesWithCircumstanceRepository lwcrepo;
	
	@Autowired
	SelectionRepository selectionRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	StudentGroupRepository repoSG;
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public String studentMenu(Model model, Principal principal) {
		Student u = srepo.findByUsername(principal.getName());
		model.addAttribute("user", u.getName());
		return "student/menu";
	}
	
	
	@RequestMapping(value = "/groupworks", method = RequestMethod.GET)
	public String coursework(Model model, Principal principal) {
		Student u = srepo.findByUsername(principal.getName());
		model.addAttribute("user", u.getName());
//		add the user courseworks to the following list 
		
		List<List<Object>> courseworks = new ArrayList<>();;
		
		for (Groupwork groupwork: u.getGroupworks()) {
			List<Object> listToAdd = new ArrayList<>();
			listToAdd.add(groupwork);
			Boolean selectionSubmitted = false;
			for (Selection selection: u.getSelections()) {
				if (selection.getGroupwork() == groupwork) {
					selectionSubmitted = true;
				}
			}
			listToAdd.add(selectionSubmitted);
			courseworks.add(listToAdd);
		}
		
		
		model.addAttribute("groupworks", courseworks);
		
		System.out.println(courseworks);
		
		return "student/groupworks";
	}
	
	
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public String projects(@RequestParam int groupwork, Model model, Principal principal) {
		Student u = srepo.findByUsername(principal.getName());
		Groupwork targetCoursework = repoG.findById(groupwork);
		
		if (targetCoursework == null || !targetCoursework.getStudents().contains(u)) {
			return "security/denied";
		}
		
		model.addAttribute("user", u.getName());
		int selections = targetCoursework.getProjects().size();
		model.addAttribute("selections", selections);
		model.addAttribute("projects", targetCoursework.getProjects());
		model.addAttribute("groupwork", targetCoursework);
		
		List<Circumstance> circumstances = new ArrayList<>();
		for (Circumstance c : targetCoursework.getCircumstances()) {
			if (c.getThisStudent() == u) {
				circumstances.add(c);
			}
		}
		
		model.addAttribute("circumstances", circumstances);
		
		return "student/projects";
	}
	
	 public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) 
	    { 
	        // Create a list from elements of HashMap 
	        List<Map.Entry<String, Integer> > list = 
	               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 
	  
	        // Sort the list 
	        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
	            public int compare(Map.Entry<String, Integer> o1,  
	                               Map.Entry<String, Integer> o2) 
	            { 
	                return (o1.getValue()).compareTo(o2.getValue()); 
	            } 
	        }); 
	          
	        // put data from sorted list to hashmap  
	        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
	        for (Map.Entry<String, Integer> aa : list) { 
	            temp.put(aa.getKey(), aa.getValue()); 
	        } 
	        return temp; 
	    } 
	
	
	@RequestMapping(value = "/selectProjects", method = RequestMethod.POST)
	public String addSelections(Model model, Principal principal, @RequestParam int groupwork, @RequestParam HashMap<String, String> frmdata) {
		Student u = srepo.findByUsername(principal.getName());
		Groupwork targetGroupwork = repoG.findById(groupwork);
		if (targetGroupwork == null || !targetGroupwork.getStudents().contains(u)) {
			return "security/denied";
		}
		
		
		model.addAttribute("user", u.getName());
		
		// Already selected once
		for (Selection sec: u.getSelections()) {
			if (sec.getGroupwork().getId().equals(groupwork)) {
				// They already have selected their stuff yo
				return "student/alreadySubmittedSelection";
			}
		}
		
		Selection s = new Selection();
		s.setGroupwork(targetGroupwork);
		List<Project> ordered = new ArrayList<Project>();
		
		HashMap<String, Integer> secs = new HashMap<String, Integer>();
		for (Map.Entry<String, String> entry: frmdata.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			    
			if (!key.equals("groupwork") && !key.equals("_csrf")) {
				secs.put(key, Integer.valueOf(value));
			}
		}
		
		Map<String, Integer> sorted = sortByValue(secs);
		for (Map.Entry<String, Integer> en : sorted.entrySet()) { 
            ordered.add(projectRepository.findById(Integer.valueOf(en.getKey())).get());
        } 
		
		s.setOrder(ordered);

		Calendar todayC = Calendar.getInstance();
		todayC.set(Calendar.HOUR_OF_DAY, 0);
		Date today = (Date) todayC.getTime();
		
		Calendar dateToCheck = Calendar.getInstance();
		Date deadline = repoG.findById(groupwork).getDeadline();
		dateToCheck.set(deadline.getYear(), deadline.getMonth(), deadline.getDate());
		dateToCheck.set(Calendar.HOUR_OF_DAY, deadline.getHours());
		dateToCheck.set(Calendar.MINUTE, deadline.getMinutes());
		dateToCheck.set(Calendar.SECOND, deadline.getSeconds());
		dateToCheck.add(Calendar.DATE, 1);
		Date dateToCheck2 = (Date) dateToCheck.getTime();
		
		System.out.println(dateToCheck2.toString());
		if (today.after(dateToCheck2)) {
			s.setLate(true);
		}
		
		selectionRepository.save(s);
		u.getSelections().add(s);
		srepo.save(u);
			
		return "redirect:/student/groupworks";
	}
	
	@RequestMapping(value = "/circumstances", method = RequestMethod.GET)
	public String circumstances(@RequestParam int groupwork, Model model, Principal principal) {
		Student u = srepo.findByUsername(principal.getName());
		Groupwork targetGroupwork = repoG.findById(groupwork);

		if (targetGroupwork == null || !targetGroupwork.getStudents().contains(u)) {
			return "security/denied";
		}
		
		List<Circumstance> allCircumstances = new ArrayList<>();
		allCircumstances.addAll(ocrepo.findAll());
		allCircumstances.addAll(lwcrepo.findAll());

		List<Circumstance> targetCircumstances = new ArrayList<>();
		
		for(Circumstance c1 : allCircumstances) {
			for(Circumstance c2 : targetGroupwork.getCircumstances()) {
				if(c1.getThisStudent().getUsername() == u.getUsername() && c1 == c2) {
					targetCircumstances.add(c1);
				}
			}
		}

		model.addAttribute("circumstances", targetCircumstances);
		model.addAttribute("groupworkId", groupwork);
		model.addAttribute("user", u.getName());

		return "student/circumstances";
	}
	
	@RequestMapping(value = "/newCircumstance")
	public String newCircumstance(@RequestParam int groupwork, Model model, Principal principal) {
		Student u = srepo.findByUsername(principal.getName());
		Groupwork g = repoG.findById(groupwork);
		model.addAttribute("user", u.getName());
		model.addAttribute("groupwork", g);
		model.addAttribute("lwCircumstance", new LivesWithCircumstance());
		model.addAttribute("oCircumstance", new OtherCircumstance());
		return "student/addCircumstance";
	}
	
	@PostMapping(value = "/addLivesWithCircumstance")
	public String createLivesWithCircumstance(@RequestParam("otherStudent") String OS, @ModelAttribute LivesWithCircumstance circumstance, @RequestParam int groupwork, Principal principal, Model model) {
		Groupwork targetGroupwork = repoG.findById(groupwork);
		
		Student thisStudent = srepo.findByUsername(principal.getName());
		
		if (thisStudent == null || targetGroupwork == null || !thisStudent.getGroupworks().contains(targetGroupwork)) {
			return "security/error";
		}
		
		Student otherStudent = srepo.findByUsername(OS);
		if (otherStudent == null || !otherStudent.getGroupworks().contains(targetGroupwork)) {
			model.addAttribute("status", "User '" + OS + "' does not exist!");
			model.addAttribute("user", thisStudent.getName());
			model.addAttribute("groupwork", targetGroupwork);
			model.addAttribute("lwCircumstance", new LivesWithCircumstance());
			model.addAttribute("oCircumstance", new OtherCircumstance());
			return "student/addCircumstance";
		}
		
		if (otherStudent == thisStudent) {
			model.addAttribute("status", "You cannot state that you live with yourself!");
			model.addAttribute("user", thisStudent.getName());
			model.addAttribute("groupwork", targetGroupwork);
			model.addAttribute("lwCircumstance", new LivesWithCircumstance());
			model.addAttribute("oCircumstance", new OtherCircumstance());
			return "student/addCircumstance";
		}
		
		circumstance.setThisStudent(thisStudent);
		circumstance.setOtherStudent(otherStudent);
		lwcrepo.save(circumstance);
		
		targetGroupwork.getCircumstances().add(circumstance);
		repoG.save(targetGroupwork);
		
		return "redirect:/student/circumstances?groupwork=" + groupwork;
		
	}
	
	@PostMapping(value = "/addOtherCircumstance")
	public String createOtherCircumstance(@ModelAttribute OtherCircumstance circumstance, @RequestParam int groupwork, Principal principal, Model model) {

		Groupwork targetGroupwork = repoG.findById(groupwork);
		if (targetGroupwork == null || !targetGroupwork.getStudents().contains((srepo.findByUsername(principal.getName())))){
			return "security/denied";
		}
		
		circumstance.setThisStudent((srepo.findByUsername(principal.getName())));
		ocrepo.save(circumstance);
		targetGroupwork.getCircumstances().add(circumstance);
		repoG.save(targetGroupwork);
		
		return "redirect:/student/circumstances?groupwork=" + groupwork;
		
	}
	
	@RequestMapping(value = "/studentGroup", method = RequestMethod.GET)
	public String studentGroups(@RequestParam int groupwork, Model model, Principal principal) {
		
		Student targetStudent = srepo.findByUsername(principal.getName());		
		Groupwork targetGroupwork = repoG.findById(groupwork);
		
		if (targetGroupwork == null || !targetStudent.getGroupworks().contains(targetGroupwork)) {
			return "security/denied";
		}
		
		if (targetGroupwork.isGroupsReleased() == false) {
			return "redirect:groupworks";
		}
		
		List<Project> groupProjects = targetGroupwork.getProjects();
		List<StudentGroup> studentGroups = repoSG.findAll();
		
		StudentGroup targetStudentGroup = null;
		for(StudentGroup sg : studentGroups) {
			for(Student s : sg.getStudentList()) {
				if(s == targetStudent && groupProjects.contains(sg.getProject())){
					targetStudentGroup = sg;
				}
			}
		}
		
		if (targetStudentGroup == null) {
			return "student/noGroup";
		}
		
		
		String recipients = "mailto:";
		
		for(Student s : targetStudentGroup.getStudentList()) {
			if(s != targetStudent) {
				recipients = recipients + s.getUsername() + "@student.le.ac.uk,";
			}
			
		}
		
		String subject = "?subject=" + targetGroupwork.getName() + "%20Group%20" + targetStudentGroup.getId();
		String body = "&body=Hi%2C%0A%0AWe%20have%20been%20put%20into%20group%20" + targetStudentGroup.getId() + "%20for%20the%20" + targetGroupwork.getName() + "%20group%20project.%20We%20should%20start%20planning%20how%20to%20begin%20the%20'" + targetStudentGroup.getProject().getName() + "'%20project%20now.%0A%0A%0AFrom%2C%0A%0A" + targetStudent.getName();
		String mailto = recipients + subject + body;
		
		model.addAttribute("user", targetStudent.getName());
		model.addAttribute("studentGroup", targetStudentGroup);
		model.addAttribute("mailto", mailto);

		
		return "student/studentGroup";
	}

}
