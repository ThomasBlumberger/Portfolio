package com.example.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;


@Entity
@Inheritance
@DiscriminatorColumn(name = "type")
public abstract class Circumstance {
	
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Student thisStudent;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getThisStudent() {
		return thisStudent;
	}
	public void setThisStudent(Student thisStudent) {
		this.thisStudent = thisStudent;
	}
	@Override
	public String toString() {
		return "Circumstance [id=" + id + ", thisStudent=" + thisStudent;
	}
	
	public String getHtmlString() {
		return "<h2>Student: " + thisStudent.getName() + "</h2> <br/>";
	}
}
