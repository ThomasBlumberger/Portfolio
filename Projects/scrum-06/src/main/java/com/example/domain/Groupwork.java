package com.example.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.controller.EmailSystem;
import com.example.repository.GroupworkRepository;

@Entity
public class Groupwork {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	@ManyToMany
	private List<Student> unassignedStudents = new ArrayList<>();
	
	@ManyToOne 
	private Convenor author;
	
	@ManyToMany
	private List<Student> students = new ArrayList<>();
	
	private int groupSize;
	private int modulePercent;
	private boolean groupsGenerated;
	private boolean groupsReleased;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadline;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List <Project> projects = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Circumstance> circumstances = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Convenor getAuthor() {
		return author;
	}
	
	public void setAuthor(Convenor author) {
		this.author = author;
	}
	
	public int getGroupSize() {
		return groupSize;
	}
	
	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}
	
	public int getModulePercent() {
		return modulePercent;
	}
	
	public void setModulePercent(int modulePercent) {
		this.modulePercent = modulePercent;
	}
	
	public List<Project> getProjects() {
		return projects;
	}
	
	public void setProjects(List<Project> projectList) {
		this.projects = projectList;
	}
	
	
	@Override
	public String toString() {
		return "Groupwork [id=" + id + ", name=" + name + ", author=" + author + ", students=" + students
				+ ", groupSize=" + groupSize + ", modulePercent=" + modulePercent + ", projects=" + projects
				+ ", circumstances=" + circumstances + "]";
	}
	
	public List<Circumstance> getCircumstances() {
		return circumstances;
	}
	public void setCircumstances(List<Circumstance> circumstanceList) {
		this.circumstances = circumstanceList;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	public List<Student> getUnassignedStudents() {
		return unassignedStudents;
	}

	public void setUnassignedStudents(List<Student> unassignedStudents) {
		this.unassignedStudents = unassignedStudents;
	}
	

	public boolean isGroupsGenerated() {
		return groupsGenerated;
	}

	public void setGroupsGenerated(boolean groupsFormulated) {
		this.groupsGenerated = groupsFormulated;
	}

	public boolean isGroupsReleased() {
		return groupsReleased;
	}

	public void setGroupsReleased(boolean groupsReleased) {
		this.groupsReleased = groupsReleased;
	}
	
}
