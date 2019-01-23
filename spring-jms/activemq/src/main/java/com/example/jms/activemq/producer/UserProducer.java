package com.example.jms.activemq.producer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.example.jms.activemq.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class UserProducer {

	private Log log = LogFactory.getLog(UserProducer.class);
	
	@Autowired
    protected JmsTemplate jmsTemplate;
	
	@Value("${activemq.destination.name}")
    private String queueName;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public void sendUser(User user) throws JsonProcessingException {
		String userString = mapper.writeValueAsString(user);
		log.info("Sending message User:"+user.toString()+" to "+queueName);
		jmsTemplate.convertAndSend(queueName, userString);
	}
	
}
