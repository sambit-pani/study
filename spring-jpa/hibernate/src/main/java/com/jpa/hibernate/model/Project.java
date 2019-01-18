package com.jpa.hibernate.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private String name;
	
	@OneToOne
	@JoinColumn(name="deliveryHead",referencedColumnName="id")
	private Employee deliveryHead;
	
	@OneToMany
	@JoinColumn(name="project",referencedColumnName="id")
	private List<Employee> employees;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "project_loc", 
				joinColumns = @JoinColumn(name = "proj_id"),
				inverseJoinColumns = @JoinColumn(name = "loc_id"))
	private Set<Location> locations;

	public Project() {}

	public Project(String name, Employee deliveryHead, Set<Location> locations) {
		super();
		this.name = name;
		this.deliveryHead = deliveryHead;
		this.locations = locations;
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

	public Employee getDeliveryHead() {
		return deliveryHead;
	}

	public void setDeliveryHead(Employee deliveryHead) {
		this.deliveryHead = deliveryHead;
	}

	public Set<Location> getLocations() {
		return locations;
	}

	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}
	
	
}
