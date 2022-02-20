package com.example.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.example.controller.EmailSystem;

@Entity
public class Student extends User {
	public Student() {
		this.getRoles().add(new Role("STUDENT"));
		this.setSelections(new ArrayList<Selection>());
	}
	
	private Boolean atRisk;
	
	@ManyToMany(mappedBy = "students")
	private List<Groupwork> groupworks;
	
	@ManyToMany(mappedBy = "unassignedStudents")
	private List<Groupwork> groupworksUnassigned;
	
	@OneToMany
	private List<Selection> selections;
	
	@ManyToMany(mappedBy = "studentList")
	private List<StudentGroup> groups;
	
	public Boolean getAtRisk() {
		return atRisk;
	}
	
	public void setAtRisk(Boolean atRisk) {
		this.atRisk = atRisk;
	}
	
	public List<Groupwork> getGroupworks() {
		return groupworks;
	}
	
	public void setGroupworks(List<Groupwork> groupworks) {
		this.groupworks = groupworks;
	}

	public List<Selection> getSelections() {
		return selections;
	}

	public void setSelections(List<Selection> selections) {
		this.selections = selections;
	}
	
	public void sendConfirmationEmail(ResetRequest r) throws MessagingException, IOException {
		com.example.Lab1S2ExAApplication.emailSystem.sendEmail(this.getEmail(), 
		"Registration",
		"<p>Greetings, " + this.getUsername() + "</p>" +
		"<p>Click this link to set your password: <a href=\"https://localhost:8443/resetPassword?key=" + r.getRequestKey() + "\"> Here </a></p>");
	}
}
