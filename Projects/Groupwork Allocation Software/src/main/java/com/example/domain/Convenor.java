package com.example.domain;

import javax.persistence.Entity;

@Entity
public class Convenor extends User {
	public Convenor() {
		this.getRoles().add(new Role("CONVENOR"));
	}
}
