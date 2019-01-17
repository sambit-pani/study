package com.jpa.hibernate;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.hibernate.model.Religion;
import com.jpa.hibernate.model.User;
import com.jpa.hibernate.model.User.SEX;
import com.jpa.hibernate.service.UserService;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args).close();
		
	}
	@Override
	public void run(String... args) throws Exception {
		/*Calendar dob = Calendar.getInstance();dob.set(1929,2,23);
		Religion r = new Religion("hindi", "sudra");
		User user = new User("namo", dob.getTime(), true, 1233.41, SEX.MALE, new Date(), new Date(), new Date(), new Date());
		user.setReligion(r);
		userService.saveUser(user);*/
		
		userService.getUserById(1);
	}
	
	

}

