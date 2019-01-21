package com.jpa.hibernate.manager;

import java.util.List;

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
		Department dept = deptRepo.findById(id).get();
		System.out.println(dept.getEmployee().size());
		return dept;
	}
	public Department getDeptByName(String name) {
		return applicationDao.getDepartmentByName(name);
	}
	public Project getProjectById(int id) {
		Project p = proRepo.findById(id).get();
		List<Employee>emps = p.getEmployees();
		System.out.println(emps.size());
		return p;
	}
	
	public Location getLocById(int id) {
		return locRepo.getOne(id);
	}
	public List<Department> getDepartments(){
		List<Department> depts = deptRepo.findAll();
		depts.stream().forEach(d -> {System.out.println(d.getEmployee().size());});
		return depts;
	}
	
	public List<Employee> getEmployees() {
		return employeeRepo.findAll();
	}
	
	public void getRowCount() {
		applicationDao.getRowCount();
	}
}
