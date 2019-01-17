package com.jpa.hibernate.manager;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.hibernate.dao.UserDao;
import com.jpa.hibernate.model.User;
import com.jpa.hibernate.repository.UserRepository;

@Transactional
@Component
public class UserManager {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDao userDao;

	public User save(User user) {
		return userRepository.save(user);
	}
	
	
	
	
}
