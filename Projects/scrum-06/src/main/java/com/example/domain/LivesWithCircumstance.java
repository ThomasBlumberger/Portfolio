package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class LivesWithCircumstance extends Circumstance {
	
	@ManyToOne
	private Student otherStudent;
	
	public Student getOtherStudent() {
		return otherStudent;
	}
	public void setOtherStudent(Student otherStudent) {
		this.otherStudent = otherStudent;
	}
	@Override
	public String toString() {
		return super.toString() + ", otherStudent=" + otherStudent + "]";
	}
	
	@Override
	public String getHtmlString() {
		return super.getHtmlString() + "<h2>Lives with: " + otherStudent.getName() + "</h2><br/>";
	}
	
}
