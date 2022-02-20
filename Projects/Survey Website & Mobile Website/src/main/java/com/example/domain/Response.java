package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="responses")
public class Response {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="sni", nullable=false)
	private User user;
	@ManyToOne
	@JoinColumn(name="question_id", nullable=false)
	private Question question;
	@ManyToOne
	@JoinColumn(name="option_id", nullable=false)
	private Option questionResponse;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Option getQuestionResponse() {
		return questionResponse;
	}

	public void setQuestionResponse(Option questionResponse) {
		this.questionResponse = questionResponse;
	}
	
}
