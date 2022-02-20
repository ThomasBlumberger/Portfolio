package com.example.domain;

import javax.persistence.Entity;

@Entity
public class Resident extends User {
	public Resident() {
		this.getRoles().add(new Role("RESIDENT"));
	}

}
