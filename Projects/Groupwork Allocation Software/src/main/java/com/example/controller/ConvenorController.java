package com.example.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.Circumstance;
import com.example.domain.Convenor;
import com.example.domain.Groupwork;
import com.example.domain.LivesWithCircumstance;
import com.example.domain.OtherCircumstance;
import com.example.domain.Project;
import com.example.domain.ResetRequest;
import com.example.domain.Selection;
import com.example.domain.Student;
import com.example.domain.StudentGroup;
import com.example.domain.User;
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
@RequestMapping("/convenor")
public class ConvenorController {

	@Autowired
	ConvenorRepository repoU;
	
	@Autowired
	StudentRepository srepo;

	@Autowired
	GroupworkRepository repoG;

	@Autowired
	ProjectRepository repoP;

	@Autowired
	OtherCircumstanceRepository ocrepo;
	
	@Autowired
	LivesWithCircumstanceRepository lwcrepo;

	@Autowired
	StudentGroupRepository repoS;
	
	@Autowired
	SelectionRepository repoSelect;
	
	@Autowired
	private ResetRequestRepository rr;
	
	@Autowired
	private PasswordEncoder pe;


	@InitBinder("groupwork")
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new GroupworkValidator());
	}

	@InitBinder("project")
	protected void initBinder1(WebDataBinder wd) {
		wd.addValidators(new ProjectValidator());
	}
	
	@InitBinder("student")
	protected void initBinder2(WebDataBinder binder2) {
		binder2.addValidators(new StudentValidator());
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String studentMenu(Model model, Principal principal) {
		Convenor u = repoU.findByUsername(principal.getName());
		model.addAttribute("user", u.getName());

		return "convenor/menu";
	}

	@RequestMapping(value = "/groupworks", method = RequestMethod.GET)
	public String groupwork(Model model, Principal principal) {
		Convenor u = repoU.findByUsername(principal.getName());
		model.addAttribute("user", u.getName());

		List<Groupwork> allGroupworks = repoG.findAll();
		List<Groupwork> groupworks = new ArrayList<>();
		
		for( Groupwork g : allGroupworks) {
			if(g.getAuthor() == u) {
				groupworks.add(g);
			}
		}
		model.addAttribute("groupworks", groupworks);
		
		return "convenor/groupworks";
	}

	@RequestMapping(value = "/newGroupwork")
	public String newGroupwork(Model model, Principal principal) {
		Convenor u = repoU.findByUsername(principal.getName());
		model.addAttribute("user", u.getName());
		model.addAttribute("groupwork", new Groupwork());
		return "convenor/createGroupwork";
	}

	@PostMapping(value = "/addGroupwork")
	public String createGroupwork(@Valid @ModelAttribute Groupwork groupwork, BindingResult result, Principal principal,
			Model model) {
		if (result.hasErrors()) {
			Convenor u = repoU.findByUsername(principal.getName());
			model.addAttribute("user", u.getName());
			return "convenor/createGroupwork";
		}

		groupwork.setAuthor((Convenor) repoU.findByUsername(principal.getName()));
		repoG.save(groupwork);

		return "redirect:/convenor/groupworks";
	}
	
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public String projects(@RequestParam int groupwork, Model model, Principal principal) {
		Convenor u = repoU.findByUsername(principal.getName());
		model.addAttribute("user", u.getName());

		Groupwork targetGroupwork = repoG.findById(groupwork);
		
		if (targetGroupwork == null || targetGroupwork.getAuthor() != u) {
			return "security/denied";
		}
		
		model.addAttribute("projects", targetGroupwork.getProjects());
		model.addAttribute("groupworkID", targetGroupwork.getId());

		return "convenor/projects";
	}

	@RequestMapping(value = "/newProject")
	public String newProject(@RequestParam int groupwork, Model model, Principal principal) {
		Convenor u = repoU.findByUsername(principal.getName());
		model.addAttribute("user", u.getName());
		model.addAttribute("groupworkID", groupwork);
		model.addAttribute("project", new Project());

		return "convenor/createProject";
	}

	@PostMapping(value = "/addProject")
	public String createProject(@Valid @ModelAttribute Project project, BindingResult result, @RequestParam int groupwork, Principal principal, Model model) {		

		Groupwork targetGroupwork = repoG.findById(groupwork);
		if (targetGroupwork == null || targetGroupwork.getAuthor() != repoU.findByUsername(principal.getName())) {
			return "security/denied";
		}
		
		
		if (result.hasErrors()) {
			Convenor u = repoU.findByUsername(principal.getName());
			model.addAttribute("user", u.getName());
			model.addAttribute("groupworkID", groupwork);
			return "convenor/createProject";
		}
		
		for (int i = 0 ; i < project.getMaxNumOfProjects(); i++ ){
			StudentGroup g = new StudentGroup();
			g.setProject(project);
			project.getStudentGroups().add(g);
			
		}
		project.setCoursework(targetGroupwork);
		repoP.save(project);
		targetGroupwork.getProjects().add(project);
		repoG.save(targetGroupwork);
		
		return "redirect:/convenor/projects?groupwork=" + groupwork;
	}
	
	@RequestMapping(value = "/removeProject")
	public String removeProject(@RequestParam int project, @RequestParam int groupwork, Principal principal) {
		Convenor convenor = repoU.findByUsername(principal.getName());
		Project targetProject = repoP.findById(project);
		List<Groupwork> allGroupworks = repoG.findAll();
		Groupwork targetGroupwork = repoG.findById(groupwork);
		Project projectToRemove = new Project();
		List<StudentGroup> groupsToRemove = new ArrayList<>();
		
		
		if (targetGroupwork == null || targetProject == null || targetGroupwork.getAuthor() != convenor || targetProject.getCoursework() != targetGroupwork) {
			return "security/denied";
		}

		for(Groupwork g : allGroupworks) {
			for(Project p : g.getProjects()) {
				if(p == targetProject) {
					projectToRemove = p;
					for (StudentGroup group : p.getStudentGroups()) {
						for (Student s : group.getStudentList()) {
							for (Selection selection : s.getSelections()) {
								if (selection.getGroupwork() == targetGroupwork) {
									selection.getOrder().remove(p);
								}
							}
						}
					
					}
				}
			}
			projectToRemove.getStudentGroups().removeAll(groupsToRemove);
			g.getProjects().remove(projectToRemove);
			repoG.save(g);
		}
		
		repoP.delete(targetProject);
		
		return "redirect:/convenor/projects?groupwork=" + groupwork;
		
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String addStudents(@RequestParam int groupwork, Model model, Principal principal) {
		Convenor u = repoU.findByUsername(principal.getName());
		model.addAttribute("user", u.getName());

		Groupwork targetGroupwork = repoG.findById(groupwork);
		
		if (targetGroupwork.getAuthor() != u) {
			return "security/denied";
		}
		
		model.addAttribute("groupwork", targetGroupwork);

		return "convenor/students";
	}
	
	@RequestMapping(value = "/sendReminder", method = RequestMethod.GET)
	public String sendReminder(@RequestParam int groupwork, Model model, Principal principal) {
		Convenor u = repoU.findByUsername(principal.getName());
		Groupwork targetGroupwork = repoG.findById(groupwork);
		if (targetGroupwork == null || targetGroupwork.getAuthor() != u) {
			return "security/denied";
		}
		
		for (Student s: targetGroupwork.getStudents()) {
			try {
				com.example.Lab1S2ExAApplication.emailSystem.sendEmail(s.getEmail(), 
				"Selection Reminder",
				"<p>Greetings, " + s.getUsername() + "</p>" +
				"<p>This is a reminder for " + targetGroupwork.getName() + "</p>" +
				"<p>To select your project preferences <a href=\"https://localhost:8443/\">login</a>.</p>");
			} catch (MessagingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return "redirect:/convenor/groupworks";
	}


	@RequestMapping("/removeStudent")
	public String removeStudent (@RequestParam String username, @RequestParam int groupwork, Model model, Principal principal){
		Student targetStudent = srepo.findByUsername(username);
		Groupwork targetGroupwork = repoG.findById(groupwork);
		
		if (targetStudent == null || targetGroupwork == null || !targetGroupwork.getStudents().contains(targetStudent) || targetGroupwork.getAuthor() != repoU.findByUsername(principal.getName())) {
			return "security/denied";
		}
		
		//remove student from studentgroup for this groupwork
		StudentGroup targetStudentGroup = null;
		for(Project p : targetGroupwork.getProjects()) {
			for(StudentGroup sg : p.getStudentGroups()) {
				for(Student s : sg.getStudentList()) {
					if(s == targetStudent) {
						targetStudentGroup = sg; 
					}
				}
			}
		}
		
		if(targetStudentGroup != null) {
			targetStudentGroup.getStudentList().remove(targetStudent);
		}
		
		//remove circumstances from the groupwork
		List<Groupwork> allGroupworks = repoG.findAll();
		List<OtherCircumstance> toRemoveOther = new ArrayList<>();
		List<LivesWithCircumstance> toRemoveLives = new ArrayList<>();
		for(Groupwork g : allGroupworks) {
			for(Circumstance c : g.getCircumstances()) {
				if(c.getThisStudent() == targetStudent) {
					
					if (c instanceof LivesWithCircumstance) {
						toRemoveLives.add((LivesWithCircumstance) c);
					}
					else {
						toRemoveOther.add((OtherCircumstance) c);
					}
				}
				if(c instanceof LivesWithCircumstance) {
					if(((LivesWithCircumstance) c).getOtherStudent() == targetStudent && !toRemoveLives.contains(c)) {
						toRemoveLives.add((LivesWithCircumstance) c);
					}
				}
			}
			if(!toRemoveLives.isEmpty()) {
				g.getCircumstances().removeAll(toRemoveLives);
			}
			
			if(!toRemoveOther.isEmpty()) {
				g.getCircumstances().removeAll(toRemoveOther);
			}
			repoG.save(g);
		}
	
		//delete any circumstance links via 'lives with'
		List<LivesWithCircumstance> livesWithCirc = lwcrepo.findAll();
		for(LivesWithCircumstance c : livesWithCirc) {
			if(c.getOtherStudent() == targetStudent) {
				toRemoveLives.add(c);
			}
		}
		
		//delete circumstances
		if(!toRemoveLives.isEmpty()) {
			lwcrepo.deleteAll(toRemoveLives);
		}
		if(!toRemoveOther.isEmpty()) {
			ocrepo.deleteAll(toRemoveOther);
		}
		
		//delete student from groupwork
		if(!targetGroupwork.getStudents().isEmpty()) {
			targetGroupwork.getStudents().remove(targetStudent);
		}
		if(!targetGroupwork.getUnassignedStudents().isEmpty()) {
			targetGroupwork.getUnassignedStudents().remove(targetStudent);
		}
		repoG.save(targetGroupwork);
		
		return "redirect:/convenor/students?groupwork=" + groupwork;
	}
	
	@RequestMapping(value = "/removeGroupwork")
	public String removeGroupwork(@RequestParam int groupwork, Principal principal) {

		Convenor convenor = repoU.findByUsername(principal.getName());
		Groupwork targetGroupwork = repoG.findById(groupwork);
		List<Selection> selections = repoSelect.findAll();
		List<Student> students = srepo.findAll();
		
		Convenor author = targetGroupwork.getAuthor();
		if(convenor != author || targetGroupwork == null) {
			return "/security/denied";
		}
		
		//delete selections for that groupwork
		List<Selection> toDelete1 = new ArrayList<>();
		for(Selection s : selections) {
			if(s.getGroupwork() == targetGroupwork) {
				toDelete1.add(s);
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
		
		repoG.delete(targetGroupwork);
		return "redirect:/convenor/groupworks";
	}

	@RequestMapping(value = "/studentGroups", method = RequestMethod.GET)
	public String studentGroups(@RequestParam int project, @RequestParam int groupwork, Model model, Principal principal) {
		Convenor u = repoU.findByUsername(principal.getName());
		model.addAttribute("user", u.getName());

		Project targetProject = repoP.findById(project);
		List<StudentGroup> groupList = targetProject.getStudentGroups();

		Groupwork targetGroupwork = repoG.findById(groupwork);
		if (targetGroupwork == null || targetProject == null || targetGroupwork.getAuthor() != u || targetProject.getCoursework() != targetGroupwork) {
			return "security/denied";
		}
		
		
		model.addAttribute("groupworkID", groupwork);
		model.addAttribute("studentGroups", groupList);
		model.addAttribute("project", targetProject);
		return "convenor/studentGroups";
	}

	@RequestMapping(value = "/AllProjectsAndGroups", method = RequestMethod.GET)
	public String allProjectsAndGroups(@RequestParam int groupwork, Model model, Principal principal) {
		Convenor u = repoU.findByUsername(principal.getName());
		Groupwork targetGroupwork = repoG.findById(groupwork);
		if (targetGroupwork == null || targetGroupwork.getAuthor() != u) {
			return "security/denied";
		}
		model.addAttribute("projects", targetGroupwork.getProjects());
		model.addAttribute("user", u.getName());
		model.addAttribute("groupwork", groupwork);
		model.addAttribute("unassigned", targetGroupwork.getUnassignedStudents());
		return "convenor/AllProjectsAndGroups";
	}

	@RequestMapping(value = "/circumstances", method = RequestMethod.GET)
	public String studentCircumstances(@RequestParam int groupwork, Model model, Principal principal) {
		Convenor u = repoU.findByUsername(principal.getName());
		model.addAttribute("user", u.getName());

		Groupwork targetGroupwork = repoG.findById(groupwork);
		if (targetGroupwork == null || targetGroupwork.getAuthor() != u) {
			return "security/denied";
		}
		List<Circumstance> circumstances = targetGroupwork.getCircumstances();
		model.addAttribute("circumstance", circumstances);
		model.addAttribute("groupwork", targetGroupwork);

		return "convenor/circumstance";
	}
	
	@RequestMapping(value = "/removeCircumstance")
	@Transactional
	public String removeCircumstance(@RequestParam int circumstance, @RequestParam int groupwork, Principal principal) {
		Convenor convenor = repoU.findByUsername(principal.getName());
		Circumstance targetCircumstance = lwcrepo.findById(circumstance);
		Groupwork targetGroupwork = repoG.findById(groupwork);
		
		if (targetCircumstance == null) {
			targetCircumstance = ocrepo.findById(circumstance);
			targetCircumstance = (OtherCircumstance) targetCircumstance;
		}
		else {
			targetCircumstance = (LivesWithCircumstance) targetCircumstance;
		}
		List<Groupwork> allGroupworks = repoG.findAll();
		
		boolean allowedRequest = false;
		if (targetGroupwork != null && targetGroupwork.getCircumstances().contains(targetCircumstance) && targetGroupwork.getAuthor() == convenor) {
			allowedRequest = true;
		}
		
		if (targetCircumstance == null || allowedRequest == false) {
			return "security/denied";
		}
		
		Groupwork groupworkToChange = allGroupworks.get(0);
		Circumstance circumstanceToRemove = groupworkToChange.getCircumstances().get(0);
		
		for(Groupwork g : allGroupworks) {
			for(Circumstance c : g.getCircumstances()) {
				if(c == targetCircumstance) {
					groupworkToChange = g;
					circumstanceToRemove = c;
					break;
				}
				
			}
		}
		if(circumstanceToRemove != null) {
			groupworkToChange.getCircumstances().remove(circumstanceToRemove);

			repoG.save(groupworkToChange);
			
			if (targetCircumstance instanceof LivesWithCircumstance) {
				lwcrepo.deleteById(targetCircumstance.getId());
			}
			else {
				ocrepo.deleteById(targetCircumstance.getId());
			}
		}
		return "redirect:/convenor/circumstances?groupwork=" + groupwork;
	}

	@RequestMapping(value = "/moveStudent", method = RequestMethod.POST)
	public String moveStudent(@RequestParam("student") String s, @RequestParam("group") String gstr,
			@RequestParam("groupwork") int groupwork, Model model, Principal principal) {


		User u = repoU.findByUsername(principal.getName());
		Groupwork targetGroupwork = repoG.findById(groupwork);
		
		if (targetGroupwork == null || targetGroupwork.getAuthor() != u) {
			return "security/denied";
		}
		
		int g;

		try {
			g = Integer.parseInt(gstr);
		} catch (Exception e) {
			model.addAttribute("projects", targetGroupwork.getProjects());
			model.addAttribute("user", u.getName());
			model.addAttribute("groupwork", groupwork);
			model.addAttribute("unassigned", targetGroupwork.getUnassignedStudents());
			model.addAttribute("error", "Provided group id should a positive integer");
			return "convenor/AllProjectsAndGroups";
		}

		if (g <= 0) {
			model.addAttribute("projects", targetGroupwork.getProjects());
			model.addAttribute("user", u.getName());
			model.addAttribute("groupwork", groupwork);
			model.addAttribute("unassigned", targetGroupwork.getUnassignedStudents());
			model.addAttribute("error", "Provided group id should a positive integer");
			return "convenor/AllProjectsAndGroups";
		}

		Student student = srepo.findByUsername(s);
		StudentGroup newGroup = repoS.findById(g);
		Groupwork myGroupwork = repoG.findById(groupwork);

		Boolean groupBelongsToGroupwork = false;
		for (Project p : myGroupwork.getProjects()) {
			if (newGroup != null && p.getStudentGroups().contains(newGroup)) {
				groupBelongsToGroupwork = true;
			}
		}

		if (newGroup == null || groupBelongsToGroupwork == false) {
			model.addAttribute("projects", targetGroupwork.getProjects());
			model.addAttribute("user", u.getName());
			model.addAttribute("groupwork", groupwork);
			model.addAttribute("unassigned", targetGroupwork.getUnassignedStudents());
			model.addAttribute("error", "No group was found with id: " + g);
			return "convenor/AllProjectsAndGroups";
		}

		for (StudentGroup grp : repoS.findAll()) {
			if (grp.getStudentList().contains(student)) {
				grp.getStudentList().remove(student);
				repoS.save(grp);
			}
		}
		
		newGroup.getStudentList().add(student);
		repoS.save(newGroup);
		
		if (myGroupwork.getUnassignedStudents().contains(student)) {
			myGroupwork.getUnassignedStudents().remove(student);
			repoG.save(myGroupwork);
		}
		
		return "redirect:/convenor/AllProjectsAndGroups?groupwork=" + groupwork;
	}
	
	private List<List<Student>> allocationAlgorithm(List<Student> students, Groupwork groupwork) {
		List<Student> unassignedStudents = new ArrayList<>();
		List<Student> alreadyAssignedStudents = new ArrayList<>();
		
		for (Project p: groupwork.getProjects()) { //list students already assigned
			for (StudentGroup g: p.getStudentGroups()) {
				for (Student s: g.getStudentList()) {
					alreadyAssignedStudents.add(s);
				}
			}
		}
		
		for (Student s : students) { // for each student
			boolean assigned = false;
			
			if (!alreadyAssignedStudents.contains(s)) { // if student hasn't already been assigned
				//NEW SECTION
				//Check for "living with" circumstances
				List<Student> studentsInCircumstance = new ArrayList<>();
				studentsInCircumstance.add(s);
				LivesWithCircumstance tempCircumstance = null;
				for (Circumstance circumstance : groupwork.getCircumstances()) { // find students living together
					
					if (circumstance instanceof LivesWithCircumstance && circumstance.getThisStudent() == s) {
						tempCircumstance = (LivesWithCircumstance) circumstance;
						if (!alreadyAssignedStudents.contains(tempCircumstance.getOtherStudent())) {
							studentsInCircumstance.add(tempCircumstance.getOtherStudent());
						}
					}
				}
				studentsInCircumstance = studentsInCircumstance.stream() // remove duplicates
	                    .distinct()
	                    .collect(Collectors.toList());
				
				if (studentsInCircumstance.size() > 1) {
					// WIP
					StudentGroup bestFitGroup = null;
					
					for (Selection selection: s.getSelections()) {
						if (selection.getGroupwork() == groupwork) {
							
							while (bestFitGroup == null && studentsInCircumstance.size() > 0) {
								
								outerloop :for (Project project: selection.getOrder()) {
									
									// find a group with the best fit for all the students in the circumstance according to the current preference
									for (StudentGroup group : project.getStudentGroups()) {
										
										int space = (groupwork.getGroupSize() - group.getStudentList().size());
										if (bestFitGroup == null) {
											if (space >= studentsInCircumstance.size()) { // if group has requisite space
												if (s.getAtRisk() == true) { // check if group
													boolean groupContainsAtRisk = false;
													for (Student student : group.getStudentList()) {
														if (student.getAtRisk() == true) {
															groupContainsAtRisk = true;
														}
													}
													if (groupContainsAtRisk == false) {
														bestFitGroup = group;
													}
												}
												else {
													bestFitGroup = group;
												}
											}
										}
										else {
											int spaceCurrentBest = (groupwork.getGroupSize() - bestFitGroup.getStudentList().size());
											if (space < spaceCurrentBest && space >= studentsInCircumstance.size()) {
												bestFitGroup = group;
											}
										}
									}
									if (bestFitGroup != null) { // if a group has been found for this preference...
										for (Student student : studentsInCircumstance) { // Put students into the group
											bestFitGroup.getStudentList().add(student);
											alreadyAssignedStudents.add(student); // after putting students into a group, also add them to an arraylist that keeps track of already assigned students
										}
										repoG.save(groupwork);
										break outerloop; // finish the loop
									}
									// if bestFitGroup is still null, move onto the next preference of projects
								}
								// if a group cant be found for all the students living together, remove one student and try again...
								if (bestFitGroup == null) {
									studentsInCircumstance.remove(studentsInCircumstance.size()-1); // if no group found, take out one student, repeat until space found
								}
								if (studentsInCircumstance.size() == 0) { // If no group can be found for even this student on their own, add them to the unassigned list
									unassignedStudents.add(s);
								}
							}
						}
					}
					// END OF NEW SECTION
				}
				else {
					for (Selection selection : s.getSelections()) {

						if (selection.getGroupwork() == groupwork) { // for the selection for this groupwork
							outerloop: for (Project item : selection.getOrder()) { // iterate through preferences
								
								Project project = repoP.findById(item.getId());
								for (StudentGroup group : project.getStudentGroups()) { // look through groups for that project
									if (group.getStudentList().size() < groupwork.getGroupSize()) { // if there is space
										
										if (s.getAtRisk() == true) {
											boolean groupContainsAtRisk = false;
											for (Student student : group.getStudentList()) {
												if (student.getAtRisk() == true) {
													groupContainsAtRisk = true;
												}
											}
											if (groupContainsAtRisk == false) {
												group.getStudentList().add(s); // assign
												repoP.save(project);
												assigned = true;
												break outerloop;
											}
										}
										else {
											group.getStudentList().add(s); // assign
											repoP.save(project);
											assigned = true;
											break outerloop;
										}
									}
								}
							}
						}
					}
					if (assigned == false) {
						unassignedStudents.add(s);
					}
				}
			}
		}
		List<List<Student>> returnList = new ArrayList<>();
		returnList.add(unassignedStudents);
		returnList.add(alreadyAssignedStudents);
		return returnList;
	}
	
	
	
	@RequestMapping(value= "/formulateGroups")
	public String formulateGroups(@RequestParam("groupwork") int g, Principal principal) {
		
		Convenor u = repoU.findByUsername(principal.getName());
		Groupwork groupwork = repoG.findById(g);
		
		if (groupwork == null || groupwork.getAuthor() != u) {
			return "security/denied";
		}
		
		List<Student> students = groupwork.getStudents();
		
		//remove all prior group allocations
		for (Project project : groupwork.getProjects()) {
			for (StudentGroup studentGroup : project.getStudentGroups()){
				List<Student> sl = new ArrayList<Student>();
				studentGroup.setStudentList(sl);
			}
			repoP.save(project);
		}
		

		List<Student> unassignedStudents = new ArrayList<>();
		List<Student> studentsOnTime = new ArrayList<>();
		List<Student> studentsLate = new ArrayList<>();
		List<Student> studentsNoSelection = new ArrayList<>();
		
		
		for (Student student : students) { // separate students that submitted after the deadline
			boolean selectionFound = false;
			for (Selection selection : student.getSelections()) {
				if (selection.getGroupwork() == groupwork) {
					selectionFound = true;
					if (selection.isLate()) {
						studentsLate.add(student);
					}
					else {
						studentsOnTime.add(student);
					}
				}
			}
			if (selectionFound == false) {
				studentsNoSelection.add(student);
			}
		}
		

		Collections.shuffle(studentsOnTime); // randomise students
		Collections.shuffle(studentsLate); // randomise students
		Collections.shuffle(studentsNoSelection); // randomise students
		
		//do algorithm, prioritising on time submissions over late ones
		List<List<Student>> x = allocationAlgorithm(studentsOnTime, groupwork);
		List<List<Student>> y = allocationAlgorithm(studentsLate, groupwork);
		
		
		
		unassignedStudents.addAll(x.get(0)); // add unassigned students to list
		unassignedStudents.addAll(y.get(0)); // add unassigned students to list
		
		List<Student> alreadyAssignedStudents = new ArrayList<>();
		alreadyAssignedStudents.addAll(x.get(1));
		alreadyAssignedStudents.addAll(y.get(1));
		
		for (Student s : studentsNoSelection) { // finally, find spaces for students with no submitted preferences
			
			if (!alreadyAssignedStudents.contains(s)) {
				boolean assigned = false;
				outerloop: for (Project project : groupwork.getProjects()) {
					for (StudentGroup group : project.getStudentGroups()) {
						if (group.getStudentList().size() < groupwork.getGroupSize()) {
							if (s.getAtRisk() == true) {
								boolean groupContainsAtRisk = false;
								for (Student student : group.getStudentList()) {
									if (student.getAtRisk() == true) {
										groupContainsAtRisk = true;
									}
								}
								if (groupContainsAtRisk == false) {
									group.getStudentList().add(s); // assign
									repoP.save(project);
									assigned = true;
									break outerloop;
								}
							}
							else {
								group.getStudentList().add(s); // assign
								repoP.save(project);
								assigned = true;
								break outerloop;
							}
						}
					}
				}
				if (assigned == false) {
					unassignedStudents.add(s);
				}
			}
		}
		

		groupwork.getUnassignedStudents().clear();
		for (Student student : unassignedStudents) {
			groupwork.getUnassignedStudents().add(student);
			repoG.save(groupwork);
		}
		
		groupwork.setGroupsGenerated(true);
		repoG.save(groupwork);
		
		return "redirect:/convenor/AllProjectsAndGroups?groupwork=" + g;
	}
	
	@RequestMapping("releaseGroups")
	public String releaseGroups(@RequestParam int groupwork, Model model, Principal principal) {
		Groupwork targetGroupwork = repoG.findById(groupwork);
		Convenor u = repoU.findByUsername(principal.getName());
		if (targetGroupwork != null && targetGroupwork.getAuthor() == u) {
			targetGroupwork.setGroupsReleased(true);
			repoG.save(targetGroupwork);
			
			for (Student s: targetGroupwork.getStudents()) {
				try {
					com.example.Lab1S2ExAApplication.emailSystem.sendEmail(s.getEmail(), "Groups released",
					"<p>Greetings, " + s.getUsername() + "</p>" +
					"<p>Groups have been released for " + targetGroupwork.getName() + "</p>" +
					"<p>To view your groups <a href=\"https://localhost:8443/\">login</a>.</p>");
				} catch (MessagingException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			return "security/denied";
		}
		return "redirect:groupworks";
	}
	
	@RequestMapping(value = "studentInformation", method = RequestMethod.GET)
	public String studentInformation(@RequestParam("student") String studentUsername, @RequestParam("groupwork") int groupworkId, Model model, Principal principal){
		Groupwork groupwork = repoG.findById(groupworkId);
		Convenor convenor = repoU.findByUsername(principal.getName());
		Student student = srepo.findByUsername(studentUsername);
		
		if (groupwork == null || groupwork.getAuthor() != convenor || (!student.getGroupworks().contains(groupwork))) {
			return "security/denied";
		}
		
		model.addAttribute("user", convenor.getName());
		model.addAttribute("student", student);
		
		Selection selection = null;
		for (Selection s : student.getSelections()) {
			if (s.getGroupwork() == groupwork) {
				selection = s;
			}
		}
		
		String selectionString = "&emsp; Project preferences in order of most to least favourite: <br /><br />";
		int counter = 1;
		if (selection != null) {
			for (Project p : selection.getOrder()) {
				selectionString += "&emsp;&emsp;&ensp;" + counter + " - " + (p.getName() + "<br />");
				counter ++;
			}
		}
		else {
			selectionString = "&emsp; preferences have not yet been submitted.";
		}
		model.addAttribute("selection", selectionString);
		model.addAttribute("groupworkID", groupworkId);

		return "convenor/studentInformation";
	}
	
	
	@RequestMapping(value="/manuallyAddStudent", method = RequestMethod.GET)
	public String manuallyAddStudent(@RequestParam int groupworkId, Model model, Principal principal) {
		Convenor u = repoU.findByUsername(principal.getName());
		Groupwork groupwork = repoG.findById(groupworkId);
		
		if (groupwork == null || groupwork.getAuthor() != u) {
			return "security/denied";
		}
		model.addAttribute("user", u.getName());
		model.addAttribute("groupwork", groupwork);
		model.addAttribute("student", new Student());
		return "convenor/manuallyAddStudent";
	}
	
	@RequestMapping(value="/addStudent", method = RequestMethod.POST)
	public String manuallyAddStudent(@Valid @ModelAttribute Student student, BindingResult result, @RequestParam int groupwork, Model model, Principal principal) {
		
		Groupwork targetGroupwork = repoG.findById(groupwork);
		Convenor u = repoU.findByUsername(principal.getName());
		Student targetStudent = null;
		
		if (srepo.existsById(student.getUsername()) == true){
			targetStudent = srepo.findByUsername(student.getUsername());
		}
		
		model.addAttribute("user", u.getName());
		model.addAttribute("groupwork", targetGroupwork);
		
		if (targetGroupwork == null || targetGroupwork.getAuthor() != u) {
			return "security/denied";
		}
		
		if (result.hasErrors()) {
			return "convenor/manuallyAddStudent";
		}
		
		// If student doesnt exist, create the account
		if (targetStudent == null) {
			targetStudent = new Student();
			targetStudent.setUsername(student.getUsername()); //Student Id
			targetStudent.setName(student.getName()); //Name
			targetStudent.setPassword(pe.encode("1234")); //Password
			targetStudent.setAtRisk(student.getAtRisk());
			
			// Generate their email-address
			targetStudent.setEmail(student.getUsername() + "@student.le.ac.uk");
			
			srepo.save(targetStudent);
			try {
				targetStudent.sendConfirmationEmail(rr.save(new ResetRequest(targetStudent)));
			} catch (MessagingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (targetStudent.getGroupworks() != null && targetStudent.getGroupworks().size() > 0 && targetStudent.getGroupworks().contains(targetGroupwork)) {
			result.rejectValue("username", "","This user is already registered in this groupwork");
			return "convenor/manuallyAddStudent";
		}
		else {
			targetGroupwork.getStudents().add(targetStudent);
			repoG.save(targetGroupwork);
		}
		return "redirect:students?groupwork="+groupwork;
	}
	
	
	@RequestMapping(value= "/deleteGroup")
	public String moveStudent(@RequestParam("group") int g, @RequestParam("groupwork") int groupwork, Principal principal) {
		
		Convenor u = repoU.findByUsername(principal.getName());
		Boolean convenorOwnsGroup = false;
		
		
		StudentGroup group = repoS.findById(g);
		Groupwork targetGroupwork = repoG.findById(groupwork);
		if (targetGroupwork == null || targetGroupwork.getAuthor() != u || group.getProject().getCoursework() != targetGroupwork) {
			return "security/denied";
		}
		
		Project project = null;
		
		for (Project p: repoP.findAll()) {
			if (p.getStudentGroups().contains(group)) {
				project = p;
			}
		}
		
		Groupwork groupwork1 = null;
		for (Groupwork grpwrk : repoG.findAll()) {
			if (project != null) {
				if (grpwrk.getProjects().contains(project)) {
					groupwork1 = grpwrk;
				}
			}
		}
		if (groupwork1 != null) {
			if (groupwork1.getAuthor() == u){
				convenorOwnsGroup = true;
			}
		}
		
		if (convenorOwnsGroup == true && group != null) {
			
			for (Student student : group.getStudentList()) {
				groupwork1.getUnassignedStudents().add(student);
			}
			
			project.getStudentGroups().remove(group);
			repoP.save(project);
			
		}
		
		return "redirect:/convenor/AllProjectsAndGroups?groupwork="+groupwork;
	}
	
	@RequestMapping(value="addGroup")
	public String addGroup(@RequestParam("project") int p, Principal principal) {
		Convenor u = repoU.findByUsername(principal.getName());
		Project project = repoP.findById(p);
		
		if (project == null || project.getCoursework().getAuthor() != u) {
			return "security/denied";
		}
		
		StudentGroup group = new StudentGroup();
		project.getStudentGroups().add(group);
		repoP.save(project);
		
		return "redirect:/convenor/AllProjectsAndGroups?groupwork="+project.getCoursework().getId();
	}
	
	
}
