package co2103.hw2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Property {
	
	
	

	@Id @GeneratedValue
	private int id;
	private String address;
	private String name;
	@ManyToMany(mappedBy = "viewings")
	private List<PropertyManager> property;
	@OneToOne (orphanRemoval = true, cascade = CascadeType.ALL) 
	private Tenant headTenant;
	@OneToMany (mappedBy = "livesAt", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<Tenant> tenant;

	
	@Override
	public String toString() {
		return "Property [id=" + id + ", address=" + address + ", name=" + name
				+ ", headTenant=" + headTenant + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<PropertyManager> getProperty() {
		return property;
	}

	public void setProperty(List<PropertyManager> property) {
		this.property = property;
	}

	public Tenant getHeadTenant() {
		return headTenant;
	}

	public void setHeadTenant(Tenant headTenant) {
		this.headTenant = headTenant;
	}
	public List<Tenant> getTenant() {
		return tenant;
	}

	public void setTenant(List<Tenant> tenant) {
		this.tenant = tenant;
	}

}
