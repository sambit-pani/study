package com.example.rest.webservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

	public Optional<Topic> getTopic(int id) {
		Optional<Topic> topic = topicRepo.findById(id);
		return topic;
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
