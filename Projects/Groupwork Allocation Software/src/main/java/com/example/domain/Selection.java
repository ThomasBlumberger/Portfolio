package com.example.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;


@Entity
public class Selection {
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private Groupwork groupwork;
	
	@ManyToMany
	@OrderColumn(name="position")
	private List<Project> order;
	
	@Column(name="late")
	private boolean late;

	public Groupwork getGroupwork() {
		return groupwork;
	}

	public void setGroupwork(Groupwork groupwork) {
		this.groupwork = groupwork;
	}

	public List<Project> getOrder() {
		return order;
	}

	public void setOrder(List<Project> order) {
		this.order = order;
	}

	public boolean isLate() {
		return late;
	}

	public void setLate(boolean late) {
		this.late = late;
	}
	
	
}
