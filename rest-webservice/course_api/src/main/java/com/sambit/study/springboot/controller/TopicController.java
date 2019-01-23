package com.sambit.study.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sambit.study.springboot.model.Topic;
import com.sambit.study.springboot.service.TopicService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TopicController {

	@Autowired
	TopicService topicService;
	
	@RequestMapping("topics")
	public List<Topic> getTopics(){
		return topicService.getTopics();
	}
	
	@RequestMapping("topics/{id}")
	public Topic getTopic(@PathVariable("id") int id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(value="topics", method=RequestMethod.POST)
	public Topic addTopic(@RequestBody Topic topic) {
		return topicService.addTopic(topic);
	}
	
    @RequestMapping(value="topics/{id}", method=RequestMethod.PUT)
	public Topic updateTopic(@RequestBody Topic topic,@PathVariable("id") int id) {
    	return topicService.updateTopic(topic);
    }
    
    @RequestMapping(value="topics/{id}",method=RequestMethod.DELETE)
    public void deleteTopic(@PathVariable("id")int id) {
    	topicService.deleteTopic(id);
    }
	
}
