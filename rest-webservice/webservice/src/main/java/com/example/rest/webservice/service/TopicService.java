package com.example.rest.webservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.webservice.model.Topic;
import com.example.rest.webservice.repository.TopicRepository;


@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepo;
	
	public List<Topic> getTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepo.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopic(int id) {
		return topicRepo.findById(id).get();
	}

	public Topic addTopic(Topic topic) {
		return topicRepo.save(topic);
	}

	public Topic updateTopic(Topic topic) {
		return topicRepo.save(topic);
	}

	public void deleteTopic(int id) {
		topicRepo.deleteById(id);
	}
}
