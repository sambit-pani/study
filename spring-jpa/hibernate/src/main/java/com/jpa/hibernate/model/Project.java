package com.jpa.hibernate.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="project")
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private String name;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="deliveryHead",referencedColumnName="id")
	private Employee deliveryHead;
	
	@OneToMany(mappedBy="project")
	@Fetch(FetchMode.JOIN)
	private List<Employee> employees;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name = "project_loc", 
				joinColumns = @JoinColumn(name = "proj_id"),
				inverseJoinColumns = @JoinColumn(name = "loc_id"))
	private Set<Location> location;

	public Project() {}

	public Project(String name, Employee deliveryHead, Set<Location> location) {
		super();
		this.name = name;
		this.deliveryHead = deliveryHead;
		this.location = location;
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

	public Set<Location> getLocation() {
		return location;
	}

	public void setLocation(Set<Location> location) {
		this.location = location;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
