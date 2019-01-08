package com.example.mongodb.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongodb.manager.DepartmentManager;
import com.example.mongodb.model.Department;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentManager manager;

	public void saveDepartment() {
		Department dept1 = new Department();
		dept1.setId(4l);
		dept1.setName("Support");
		dept1.setLocation("Bangalore");
		dept1.setCreated(new Date());
		dept1.setModified(new Date());
		
		manager.saveDepartment(dept1);
	}
	public DepartmentManager getManager() {
		return manager;
	}

	public void setManager(DepartmentManager manager) {
		this.manager = manager;
	}
	
	
}
