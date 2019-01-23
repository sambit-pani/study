package com.example.jms.activemq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
public class JMSConfiguration {

	@Value("${activemq.broker.url}")
    private String activeMqBrokerUrl;
	
	@Value("${activemq.destination.name}")
	private String destinationName;
	
}
