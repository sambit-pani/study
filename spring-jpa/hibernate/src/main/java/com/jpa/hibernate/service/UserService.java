package com.jpa.hibernate.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.hibernate.manager.UserManager;
import com.jpa.hibernate.model.User;
import com.jpa.hibernate.model.User.SEX;

@Service
public class UserService {

	private Log log = LogFactory.getLog(UserService.class);
	
	@Autowired
	private UserManager userManager;

	public void saveUser(User user) {
		User savedUser = userManager.save(user);
		log.info("User is saved with id:"+savedUser.getId());
	}
	
	public void getUserById(int id) {
		User user = userManager.getUserById(id);
		log.info("User retrieved:"+user);
	}
	
	public void showUsersByOrder() {
		List<User> users = userManager.getUserByOrder();
		users.stream().forEach(user -> {System.out.println(user.getName());});
	}
	
	public void showUsersBySex(SEX sex) {
		List<User> users = userManager.getUsersBySex(sex);
		users.stream().forEach(user -> {System.out.println(user.getName());});
	}
}
