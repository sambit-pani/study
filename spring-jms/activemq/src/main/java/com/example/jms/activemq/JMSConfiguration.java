package com.example.jms.activemq;

import javax.jms.ConnectionFactory;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import com.example.jms.activemq.listener.UserListener;

@Configuration
@EnableJms
public class JMSConfiguration {
	
	private Log log = LogFactory.getLog(getClass());

	/*@Value("${activemq.broker.url}")
	private String activeMqBrokerUrl;*/

	@Value("${activemq.destination.name}")
	private String destinationName;

	@Autowired
	private UserListener userListener;
	
	@Autowired
	ConnectionFactory connectionFactory;

	
	/*
	 * 
	 *  ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
	 @Bean(name = "jmsTemplate")
	public JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory);
		return jmsTemplate;
	}*/
	@Bean(name = "defaultMessageListenerContainer")
    public DefaultMessageListenerContainer messageListenerContainer(){
		//connectionFactory.setBrokerURL(activeMqBrokerUrl);
    	log.info("Queue name: " + destinationName);
        DefaultMessageListenerContainer defaultMessageListenerContainer = new DefaultMessageListenerContainer();
        defaultMessageListenerContainer.setConnectionFactory(connectionFactory);
        defaultMessageListenerContainer.setDestinationName(destinationName);
        defaultMessageListenerContainer.setMessageListener(userListener);
        defaultMessageListenerContainer.setConcurrency("2-10");
        defaultMessageListenerContainer.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
        return defaultMessageListenerContainer;
    }
	
}
