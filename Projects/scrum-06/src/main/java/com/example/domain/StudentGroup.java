package com.example.domain;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class StudentGroup {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Project project;
	@ManyToMany
	private List <Student> studentList = new ArrayList<>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	@Override
	public String toString() {
		return "StudentGroup [id=" + id + ", project=" + project + ", studentList=" + studentList + "]";
	}
}
