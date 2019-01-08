package com.example.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongodb.model.Department;

public interface DepartmentRepository extends MongoRepository<Department,Long> {

}
