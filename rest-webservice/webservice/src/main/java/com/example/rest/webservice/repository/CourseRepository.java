package com.example.rest.webservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.rest.webservice.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer>{

	public List<Course> findCourseByTopicId(int id);
}
