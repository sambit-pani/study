package com.example.rest.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.webservice.model.Course;
import com.example.rest.webservice.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	CourseService service;
	
	@RequestMapping("courses")
	public List<Course> getAllCourse(){
		return service.getAllCourses();
	}
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourseByTopic(@PathVariable("topicId") int topicId){
		return service.getCourseByTopic(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourseById(@PathVariable("courseId") int courseId) {
		return service.getCourseById(courseId);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses",method=RequestMethod.POST)
	public Course saveCourse(@PathVariable("topicId") int topicId,@RequestBody Course course) {
		return service.addAndUpdateCourse(course, topicId);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses/{courseId}",method=RequestMethod.PUT)
	public Course updateCourse(@RequestBody Course course,@PathVariable("topicId") int topicId) {
		return service.addAndUpdateCourse(course, topicId);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses/{courseId}",method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable("courseId") int courseId) {
		service.deleteCourse(courseId);
	}
}
