package co2103.hw2.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class PropertyManager {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "propmanager_id")
	@SequenceGenerator(name = "propmanager_id", sequenceName = "manager_id", initialValue = 1000)
	private int id;
	private String name;
	private int extension;
	@ManyToMany 
	private List<Property> viewings;
	@OneToMany(orphanRemoval = false, fetch = FetchType.LAZY) @JoinColumn
	private List<Tenant> PropertyManagerContact;
	@OneToMany (orphanRemoval = false)@JoinColumn
	private List<Property> manager;

	@Override
	public String toString() {
		return "PropertyManager [id=" + id + ", name=" + name + ", extension=" + extension + ", PropertyManagerContact=" + PropertyManagerContact + ", viewings=" + viewings + ", manager=" + manager + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getExtension() {
		return extension;
	}
	public void setExtension(int extension) {
		this.extension = extension;
	}
	public List<Property> getProperty() {
		return viewings;
	}
	public void setProperty(List<Property> viewings) {
		this.viewings = viewings;
	}
	public List<Tenant> getTenants() {
		return PropertyManagerContact;
	}
	public void setTenants(List<Tenant> PropertyManagerContact) {
		this.PropertyManagerContact = PropertyManagerContact;
	}
	public List<Property> getManages() {
		return manager;
	}
	public void setManages(List<Property> manager) {
		this.manager = manager;
	}
}