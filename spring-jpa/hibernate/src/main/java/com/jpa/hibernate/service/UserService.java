package com.jpa.hibernate.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.hibernate.manager.UserManager;
import com.jpa.hibernate.model.User;

@Service
public class UserService {

	private Log log = LogFactory.getLog(UserService.class);
	
	@Autowired
	private UserManager userManager;

	public void saveUser(User user) {
		User savedUser = userManager.save(user);
		log.info("User is saved with id:"+savedUser.getId());
	}
}
