package com.example.jms.activemq;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jms.activemq.model.User;
import com.example.jms.activemq.producer.UserProducer;

@SpringBootApplication
public class ActivemqApplication implements CommandLineRunner{

	@Autowired
	UserProducer producer;
	
	public static void main(String[] args) {
		SpringApplication.run(ActivemqApplication.class, args).close();;
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User(1, "sambit pani", new Date(2016, 11, 02));
		producer.sendUser(user);
	}

}

