package com.jpa.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.hibernate.manager.ApplicationManager;
import com.jpa.hibernate.model.Department;
import com.jpa.hibernate.model.Employee;
import com.jpa.hibernate.model.Location;
import com.jpa.hibernate.model.Project;

@Service
public class ApplicationService {

	@Autowired
	private ApplicationManager manager;
	
	public void saveEmployee(Employee emp) {
		manager.saveEmployee(emp);
	}
	public void saveDepartment(Department dept) {
		manager.saveDepartment(dept);
	}
	
	public Employee getEmployee(int id) {
		return manager.getEmployeeById(id);
	}
	public Department getDepartment(int id) {
		return manager.getDeptById(id);
	}
	
	public Project getProject(int id) {
		return manager.getProjectById(id);
	}
	public Location getLocation(int id) {
		return manager.getLocById(id);
	}
	
}
