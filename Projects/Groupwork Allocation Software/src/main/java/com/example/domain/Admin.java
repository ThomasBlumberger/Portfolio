package com.example.domain;

import javax.persistence.Entity;

@Entity
public class Admin extends User {
	public Admin() {
		this.getRoles().add(new Role("ADMIN"));
	}

}
