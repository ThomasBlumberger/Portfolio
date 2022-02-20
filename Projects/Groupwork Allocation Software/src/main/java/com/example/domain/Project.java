package com.example.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Project {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	private int maxNumOfProjects;
	
	@ManyToOne
	private Groupwork coursework;
	@OneToMany(cascade = CascadeType.ALL)
	private List <StudentGroup> studentGroups = new ArrayList<StudentGroup>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getMaxNumOfProjects() {
		return maxNumOfProjects;
	}
	public void setMaxNumOfProjects(int maxNumOfProjects) {
		this.maxNumOfProjects = maxNumOfProjects;
	}
	public Groupwork getCoursework() {
		return coursework;
	}
	public void setCoursework(Groupwork coursework) {
		this.coursework = coursework;
	}
	public List<StudentGroup> getStudentGroups() {
		return studentGroups;
	}
	public void setStudentGroups(List<StudentGroup> groups) {
		this.studentGroups = groups;
	}
	@Override
	public String toString() {
		return "Project [name=" + name + ", description=" + description + ", maxNumOfProjects=" + maxNumOfProjects
				 + "]";
	}

	
}
