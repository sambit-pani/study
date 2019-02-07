package com.example.mongodb.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.mongodb.model.Employee;
import com.example.mongodb.repository.EmployeeRepository;
import com.mongodb.client.result.UpdateResult;

@Repository
public class EmployeeManager {

	@Autowired
	private MongoTemplate template;
	
	@Autowired
	private EmployeeRepository reposiotry;

	
	public void saveEmployee(Employee employee) {
		template.save(employee);
	}
	public List<Employee> getAllEmployee() {
		reposiotry.findAll();
		return template.findAll(Employee.class);
	}
	
	public List<Employee> getEmployeeByCity(String cityName) {
		Calendar cal = Calendar.getInstance();cal.set(2015, 01, 01);
		Query query = new Query(Criteria.where("city").is("Frankfurt").and("hireDate").lt(cal.getTime()));
		return template.find(query, Employee.class);
		
	}
	public List<Employee> getEmployeesByQuery(Query query){
		return template.find(query, Employee.class);
	}
	
	public UpdateResult updateEmployee(Query query,Update update) {
		return template.updateMulti(query, update, Employee.class);
	}
	public Employee getEmployeeById(Long id) {
		return reposiotry.findById(id).get();
	}
	
	public void aggregateEmployee() {
		//template.aggregate(aggregation, inputType, outputType)
	}
	
	
	
	public MongoTemplate getTemplate() {
		return template;
	}

	public void setTemplate(MongoTemplate template) {
		this.template = template;
	}

	public EmployeeRepository getReposiotry() {
		return reposiotry;
	}

	public void setReposiotry(EmployeeRepository reposiotry) {
		this.reposiotry = reposiotry;
	}
	
	
	
}
