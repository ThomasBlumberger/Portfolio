package com.example.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="question_id")
	private Integer ID;
	private String title;
	@OneToMany(mappedBy="question")
	private List<Option> options;
	@OneToMany(mappedBy="question")
	private List<Response> responses;
	private Boolean hiddenFromResident;
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	public List<Response> getResponses() {
		return responses;
	}
	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}
	public Boolean getHiddenFromResident() {
		return hiddenFromResident;
	}
	public void setHiddenFromResident(Boolean hiddenFromResident) {
		this.hiddenFromResident = hiddenFromResident;
	}

	
	
}
