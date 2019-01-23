package com.example.jms.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class JMSConfiguration {

	@Value("${activemq.broker.url}")
	private String activeMqBrokerUrl;

	@Value("${activemq.destination.name}")
	private String destinationName;

	

	@Bean(name = "jmsTemplate")
	public JmsTemplate jmsTemplate() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(activeMqBrokerUrl);
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory);
		return jmsTemplate;
	}
	
	
}
