package com.jpa.hibernate;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.hibernate.model.Cart;
import com.jpa.hibernate.model.Department;
import com.jpa.hibernate.model.Employee;
import com.jpa.hibernate.model.Location;
import com.jpa.hibernate.model.Product;
import com.jpa.hibernate.model.Project;
import com.jpa.hibernate.model.Religion;
import com.jpa.hibernate.model.User;
import com.jpa.hibernate.model.User.SEX;
import com.jpa.hibernate.service.ApplicationService;
import com.jpa.hibernate.service.ProductService;
import com.jpa.hibernate.service.UserService;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private ProductService productService;
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args).close();
		
	}
	@Override
	public void run(String... args) throws Exception {
			
		/*Department department = applicationService.getDepartment(1);
		Department dept = new Department();//dept.setId(1);//Employee emp1 = new Employee();emp1.setId(1);
		Employee emp = new Employee("head", department, null, null, null);
		applicationService.saveEmployee(emp);*/
		
		
		Employee head = applicationService.getEmployee(4);
		Employee emp1 = applicationService.getEmployee(1);
		Employee emp2 = applicationService.getEmployee(2);
		
		emp1.setManager(head);emp2.setManager(head);
		applicationService.saveEmployee(emp1);applicationService.saveEmployee(emp2);
		//Project pro = new Project(name, deliveryHead, location)
	/*	Location loc = new Location("frankfurt");
		Project project = new Project("banking", null, new HashSet<>(Arrays.asList(loc)));
		Department dept = new Department("support");
		Employee emp = new Employee("rahul", dept, project, null, loc);
		dept.addEmployee(emp);*/
		//applicationService.saveEmployee(emp);
		//applicationService.saveDepartment(dept);
		//userService.showUsersByOrder();
		
	/*	Product p1 = new Product("p1");
		Product p2 = new Product("p2");
		Cart c = new Cart("c1");
		
		p1.getCart().add(c);
		p2.getCart().add(c);
		
		c.getProducts().add(p1);c.getProducts().add(p2);
		//productService.saveProduct(p1);productService.saveProduct(p2);
		
		productService.saveCart(c);
		productService.saveProduct(p1);
		productService.saveProduct(p2);*/
	}
	
	

}

