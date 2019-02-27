package com.jpa.hibernate.manager;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.hibernate.dao.UserDao;
import com.jpa.hibernate.model.User;
import com.jpa.hibernate.model.User.SEX;
import com.jpa.hibernate.repository.UserRepository;


@Component
public class UserManager {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDao userDao;

	public User save(User user) {
		return userRepository.save(user);
	}

	public User getUserById(int id) {
		//return userRepository.findById(id).get();
		return userDao.getUserById(id);
	}
	
	public List<User> getUserByOrder(){
		return userDao.getUsers();
	}
	
	public List<User> getUsersBySex(SEX sex){
		return userDao.getUserBySex(sex);
	}
	
	public void testHibernate() {
		userDao.testHibernate();
	}
}
