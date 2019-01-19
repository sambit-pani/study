package com.jpa.hibernate.manager;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.hibernate.dao.ApplicationDao;
import org.springframework.stereotype.Component;

import com.jpa.hibernate.model.Department;
import com.jpa.hibernate.model.Employee;
import com.jpa.hibernate.model.Location;
import com.jpa.hibernate.model.Project;
import com.jpa.hibernate.repository.DepartmentRepository;
import com.jpa.hibernate.repository.EmployeeRepository;
import com.jpa.hibernate.repository.LocationRepository;
import com.jpa.hibernate.repository.ProjectRepository;

@Transactional
@Component
public class ApplicationManager {
	
	@Autowired
	private ApplicationDao applicationDao;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private DepartmentRepository deptRepo;
	
	@Autowired
	private ProjectRepository proRepo;
	
	@Autowired
	private LocationRepository locRepo;

	public void saveEmployee(Employee emp) {
		applicationDao.saveEmployee(emp);
	}

	public void saveDepartment(Department dept) {
		applicationDao.saveDepartment(dept);
	}
	public void saveProject(Project proj) {
		applicationDao.saveProject(proj);
	}
	
	public void saveLocation(Location loc) {
		applicationDao.saveLocation(loc);
	}
	
	public Employee getEmployeeById(int id) {
		Employee emp =employeeRepo.findById(id).get();
		return emp;
	}
	
	public Department getDeptById(int id) {
		return deptRepo.findById(id).get();
	}
	
	public Project getProjectById(int id) {
		return proRepo.findById(id).get();
	}
	
	public Location getLocById(int id) {
		return locRepo.getOne(id);
	}
}
