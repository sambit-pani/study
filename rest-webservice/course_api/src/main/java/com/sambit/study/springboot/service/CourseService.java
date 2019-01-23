package com.sambit.study.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sambit.study.springboot.model.Course;
import com.sambit.study.springboot.model.Topic;
import com.sambit.study.springboot.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepo;
	
	public List<Course> getAllCourses(){
		List<Course> courses = new ArrayList<Course>();
		courseRepo.findAll().forEach(courses::add);
		return courses;
	}
	
	public List<Course> getCourseByTopic(int topicId){
		return courseRepo.findCourseByTopicId(topicId);
	}
	
	public Course getCourseById(int id) {
		return courseRepo.findById(id).get();
	}
	
	public Course addAndUpdateCourse(Course course, int topicId) {
		Topic topic = new Topic();topic.setId(topicId);course.setTopic(topic);
		return courseRepo.save(course);
	}
	
	public void deleteCourse(int id) {
		courseRepo.deleteById(id);
	}
}
