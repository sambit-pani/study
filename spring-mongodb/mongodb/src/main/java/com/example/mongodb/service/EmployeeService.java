package com.example.mongodb.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.mongodb.manager.DepartmentManager;
import com.example.mongodb.manager.EmployeeManager;
import com.example.mongodb.model.Department;
import com.example.mongodb.model.Employee;
import com.example.mongodb.model.Rating;
import com.mongodb.client.result.UpdateResult;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeManager manager;
	
	@Autowired
	private DepartmentManager deptManager;

	public void saveEmployee() {
		Employee emp1 = new Employee();
		emp1.setId(10l);
		emp1.setName("Mukesh Yadav");
		emp1.setCity("Delhi");
		emp1.setCreated(new Date());
		emp1.setModified(new Date());
		emp1.setActive(true);
		emp1.setSalary(21000.00);
		Calendar cal = Calendar.getInstance();cal.set(2017, 05, 24);
		emp1.setHireDate(cal.getTime());
		
		Department dept = deptManager.getDepartmentById(1l);
		emp1.setDepartment(dept);
		manager.saveEmployee(emp1);
		
	}
	
	public void getAllEmployee() {
		manager.getAllEmployee().stream().forEach(emp -> {System.out.print(emp.getName()+" : ");});
	}
	
	public void getEmployeeByCity() {
		String cityName = "Frankfurt";
		manager.getEmployeeByCity(cityName).stream().forEach(emp -> {System.out.println(emp.getName()+" : "+emp.getHireDate());});
	}
	public void getEmployeeLessThanHiredate() {
		Calendar cal = Calendar.getInstance();cal.set(2016, 01, 01);
		Query query = new Query(Criteria.where("hireDate").lt(cal));
		List<Employee> emps = manager.getEmployeesByQuery(query);System.out.println("size of emp"+emps.size());
		emps.stream().forEach(emp -> {System.out.println(emp.getName()+" "+emp.getHireDate());});
	}
	public void getEmployeeByCites() {
		Query query = new Query(Criteria.where("city").in("Bangalore","Berlin"));
		List<Employee> emps = manager.getEmployeesByQuery(query);
		emps.stream().forEach(emp -> {System.out.println(emp.getName()+" "+emp.getCity());});
	}
	public void getEmployeeWithSalaryRange() {
		Query query = new Query(Criteria.where("salary").lte(20000).gte(10000));
		List<Employee> emps = manager.getEmployeesByQuery(query);
		emps.stream().forEach(emp -> {System.out.println(emp.getName()+" "+emp.getSalary());});
	}
	public void getSalaryExists() {
		Query query = new Query(Criteria.where("salary").exists(true));
		List<Employee> emps = manager.getEmployeesByQuery(query);
		emps.stream().forEach(emp -> {System.out.println(emp.getName()+" "+emp.getSalary());});
	}
	
	public void getTypes() {
		Query query = new Query(Criteria.where("isActive").type(Type.BOOLEAN));
		List<Employee> emps = manager.getEmployeesByQuery(query);System.out.println("size of emp"+emps.size());
		emps.stream().forEach(emp -> {System.out.println(emp.getName()+" "+emp.getSalary());});
	}
	
	public void getEmployeeWithAnd() {
		Query query = new Query(Criteria.where("salary").gte(20000).and("city").is("Frankfurt"));
		List<Employee> emps = manager.getEmployeesByQuery(query);System.out.println("size of emp"+emps.size());
		emps.stream().forEach(emp -> {System.out.println(emp.getName()+" "+emp.getSalary());});
	}
	public void getEmployeeWithOr() {
		Criteria criteria = new Criteria();
		criteria.orOperator(Criteria.where("city").is("Mumbai"),Criteria.where("salary").gte(20000));
		Query query = new Query(criteria);
		List<Employee> emps = manager.getEmployeesByQuery(query);System.out.println("size of emp"+emps.size());
		emps.stream().forEach(emp -> {System.out.println(emp.getName()+" "+emp.getSalary());});
	}
	public void getEmployeeWithNot() {
		Criteria criteria = new Criteria();
		criteria.orOperator(Criteria.where("city").is("Mumbai"),Criteria.where("salary").not().lte(50000));
		Query query = new Query(criteria);
		List<Employee> emps = manager.getEmployeesByQuery(query);System.out.println("size of emp"+emps.size());
		emps.stream().forEach(emp -> {System.out.println(emp.getName()+" "+emp.getSalary()+"  "+emp.getCity());});
	}
	
	public void updateEmployee() {
		Rating rating = new Rating(2016, 5);
		Rating rating2 = new Rating(2017, 8);
		Rating rating3 = new Rating(2018, 6);
		Employee emp = manager.getEmployeeById(1l);
		emp.setRatings(Arrays.asList(rating,rating2,rating3));
		manager.saveEmployee(emp);
		 rating = new Rating(2016, 3);
		 rating2 = new Rating(2017, 9);
		 rating3 = new Rating(2018, 7);
		Employee emp2 = manager.getEmployeeById(2l);
		emp2.setRatings(Arrays.asList(rating,rating2,rating3));
		manager.saveEmployee(emp2);
		 rating = new Rating(2016,8);
		 rating2 = new Rating(2017, 10);
		 rating3 = new Rating(2018, 9);
		Employee emp3 = manager.getEmployeeById(3l);
		emp3.setRatings(Arrays.asList(rating,rating2,rating3));
		manager.saveEmployee(emp3);
		 rating = new Rating(2016,8);
		 rating2 = new Rating(2017, 5);
		 rating3 = new Rating(2018, 6);
		Employee emp4 = manager.getEmployeeById(4l);
		emp4.setRatings(Arrays.asList(rating,rating2,rating3));
		manager.saveEmployee(emp4);
	}
	
	public void arrayOperator() {
		Criteria criteria1 = Criteria.where("year").is(2018).and("rating").gte(7);
		Criteria criteria = Criteria.where("ratings.year").is(2018).and("ratings.rating").gte(7);
		criteria = Criteria.where("ratings").elemMatch(criteria1);
		Query query = new Query(criteria);
		List<Employee> emps = manager.getEmployeesByQuery(query);
		emps.stream().forEach(emp -> {System.out.println(emp.getId());});
	}
	
	public void update() {
		Update update = new Update();update.set("city", "Munich");
		update.max("ratings.0.rating", 8);
		//update.min("ratings.rating", 5);
		//update.inc("ratings.0.year", 1);
		//update.multiply("ratings.rating", 1);
		//update.rename("city", "stdt");
		update.currentDate("modified");
		
		update.push("awards").each("E","F");
		Criteria c = new Criteria();
		update.pull("awards", c.in("B","C").getCriteriaObject());
		
		Query query = new Query(Criteria.where("id").is(1));
		UpdateResult result = manager.updateEmployee(query, update);
		System.out.println(result.wasAcknowledged());
		
	}
	public EmployeeManager getManager() {
		return manager;
	}

	public void setManager(EmployeeManager manager) {
		this.manager = manager;
	}
	public DepartmentManager getDeptManager() {
		return deptManager;
	}
	public void setDeptManager(DepartmentManager deptManager) {
		this.deptManager = deptManager;
	}
}
