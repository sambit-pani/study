package com.example.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongodb.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Long>{

	List<Employee> findEmployeeByCity(String city);
}
