package com.example.rest.webservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.example.rest.webservice.model.Course;
import com.example.rest.webservice.model.Topic;
import com.example.rest.webservice.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	HibernateTemplate template;
	
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

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public CourseRepository getCourseRepo() {
		return courseRepo;
	}

	public void setCourseRepo(CourseRepository courseRepo) {
		this.courseRepo = courseRepo;
	}
	
	
}
