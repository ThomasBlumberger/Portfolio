package co2103.hw2.model;




import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




@Entity
public class Tenant {
	

	@Id
	private String name;
	@ManyToOne @JoinColumn
	private Property livesAt;


	@Override
	public String toString() {
		return "Tenant [name=" + name + ", livesAt=" + livesAt.getId() +  "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Property getLivesAt() {
		return livesAt;
	}
	public void setLivesAt(Property livesAt) {
		this.livesAt = livesAt;
	}

	
}