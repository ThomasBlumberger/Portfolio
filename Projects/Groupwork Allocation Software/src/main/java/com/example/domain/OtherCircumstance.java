package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class OtherCircumstance extends Circumstance {
	
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return super.toString() + ", description=" + description + "]";
	}
	@Override
	public String getHtmlString() {
		return super.getHtmlString() + "<h2>Description: " + description + "</h2><br/>";
	}
}
