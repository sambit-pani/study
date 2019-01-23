package com.example.jms.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.example.jms.activemq.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class UserListener implements MessageListener {

	private final Log log = LogFactory.getLog(getClass());
	private final ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public void onMessage(Message message) {
		log.info("Consuming Message from Queue");
		if(message instanceof TextMessage) {
			TextMessage msg = (TextMessage) message;
			try {
				String userMessage = msg.getText();
				User user = mapper.readValue(userMessage, User.class);
				log.info("Got User details using TextMessage:"+user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(message instanceof ObjectMessage) {
			ObjectMessage objMsg = (ObjectMessage)message;
			try {
				User user = (User) objMsg.getObject();
				log.info("Got User details using ObjectMessage :"+user);
			} catch (JMSException e) {
				e.printStackTrace();
			}
			
		}
	}

}
