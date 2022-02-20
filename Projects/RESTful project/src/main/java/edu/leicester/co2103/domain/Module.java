package edu.leicester.co2103.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Module {

	@Id
	private String code;
	private String title;
	private Integer level;
	private Boolean optional;
	

	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = false, fetch = FetchType.EAGER)
	@JoinColumn (name = "module")
	private List<Session> sessions;

	public Module() {
		sessions = new ArrayList<Session>();
	}

	public Module(String code, String title, Integer level, Boolean optional) {
		this(code, title, level, optional, new ArrayList<>());
	}

	public Module(String code, String title, Integer level, Boolean optional, List<Session> sessions) {
		this.code = code;
		this.title = title;
		this.level = level;
		this.optional = optional;
		this.sessions = sessions;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Boolean isOptional() {
		return optional;
	}

	public void setOptional(Boolean optional) {
		this.optional = optional;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}



	
	
}
