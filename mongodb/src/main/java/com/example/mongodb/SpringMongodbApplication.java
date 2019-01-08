package com.example.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.mongodb.service.DepartmentService;

@SpringBootApplication
@ImportResource("classpath:application.xml")
public class SpringMongodbApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringMongodbApplication.class, args).close();;
	}

	@Autowired
	private DepartmentService deptService;
	
	
	@Override
	public void run(String... args) throws Exception {
		deptService.saveDepartment();
	}
	public DepartmentService getDeptService() {
		return deptService;
	}
	public void setDeptService(DepartmentService deptService) {
		this.deptService = deptService;
	}
	
	
}

