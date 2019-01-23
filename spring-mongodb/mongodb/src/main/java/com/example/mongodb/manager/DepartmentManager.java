package com.example.mongodb.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.example.mongodb.model.Department;
import com.example.mongodb.repository.DepartmentRepository;

@Repository
public class DepartmentManager {

	@Autowired
	private MongoTemplate template;
	
	@Autowired
	private DepartmentRepository reposiotry;
	
	
	public void saveDepartment(Department department) {
		reposiotry.save(department);
	}
	
	public Department getDepartmentById(Long id) {
		return reposiotry.findById(id).get();
	}

	public MongoTemplate getTemplate() {
		return template;
	}

	public void setTemplate(MongoTemplate template) {
		this.template = template;
	}

	public DepartmentRepository getReposiotry() {
		return reposiotry;
	}

	public void setReposiotry(DepartmentRepository reposiotry) {
		this.reposiotry = reposiotry;
	}
	
	
	
}
