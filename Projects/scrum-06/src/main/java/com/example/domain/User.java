package com.example.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;


@Entity
@Inheritance
@DiscriminatorColumn(name = "user_type")
public abstract class User {
	@Id
	private String username;
	private String name;
	private String password;
	private String email;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Role> roles = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String studentId) {
		this.username = studentId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
