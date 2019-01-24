package com.example.rest.webservice.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.rest.webservice.exception.ResourceNotFoundException;
import com.example.rest.webservice.model.Topic;
import com.example.rest.webservice.service.TopicService;

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
		Optional<Topic> topic = topicService.getTopic(id);
		if(!topic.isPresent()) {
			throw new ResourceNotFoundException("Topic Not Available");
		}
		return topic.get();
	}
	
	@RequestMapping(value = "topics", method = RequestMethod.POST)
	public ResponseEntity<Topic> addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		URI createdURI = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(topic.getId())
				.toUri();
		return ResponseEntity.created(createdURI).body(topic);
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
