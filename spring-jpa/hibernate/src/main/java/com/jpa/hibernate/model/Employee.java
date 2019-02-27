package com.jpa.hibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "deptId", referencedColumnName = "id")
	private Department department;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "project", referencedColumnName = "id")
	private Project project;
	
	@OneToOne
	@JoinColumn(name="manager",referencedColumnName="id")
	private Employee manager;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="location",referencedColumnName="id")
	private Location location;

	public Employee() {}
	
	public Employee(String name, Department department, Project project, Employee manager, Location location) {
		super();
		this.name = name;
		this.department = department;
		this.project = project;
		this.manager = manager;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Project getProject() {
		return project;
	}

	public void setProjects(Project project) {
		this.project = project;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", project=" + project.getName() + ", manager=" + manager.getName()
				+ ", location=" + location.getName() + "]";
	}
	
	
	
}
