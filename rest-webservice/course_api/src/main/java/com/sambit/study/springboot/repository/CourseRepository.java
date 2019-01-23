package com.sambit.study.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sambit.study.springboot.model.Course;

public interface CourseRepository extends CrudRepository<Course, Integer>{

	public List<Course> findCourseByTopicId(int id);
}
