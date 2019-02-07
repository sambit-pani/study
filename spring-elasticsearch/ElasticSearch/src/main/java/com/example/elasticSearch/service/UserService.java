package com.example.elasticSearch.service;

import java.util.Calendar;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.DeleteQuery;
import org.springframework.stereotype.Service;

import com.example.elasticSearch.manager.UserManager;
import com.example.elasticSearch.model.Status;
import com.example.elasticSearch.model.User;

@Service
public class UserService {

	@Autowired
	private UserManager userManager;
	
	
	public void saveUser() {
		User user = new User();
		user.setFirstName("sambit");user.setLastName("pani");
		user.setEmail("sambitpani16@gmail.com");user.setId(1l);
		user.setIsActive(true);user.setCountry("India");
		user.setCreateDate(DateTime.now().toDate());
		user.setUpdateDate(DateTime.now().toDate());
		user.setRelatives(new String[] {"mummy","daddy","didi"});
		user.setStatus(Status.Permanent);
		
		userManager.save(user);
		
		Calendar cal = Calendar.getInstance();cal.set(2016, 11, 15);
		
		User user1 = new User(2l, "manasi", "panda", "", "pmanasi.312@gmail.com", "Germany", "63263",
				cal.getTime(), DateTime.now().toDate(), false, Status.Contract, new String[] {"mummy","daddy","bhai"});
		userManager.save(user1);
		
		cal = Calendar.getInstance();cal.set(2017, 11, 15);
		User user2 = new User(3l, "tutli", "", "", "tutli@gmail.com", "India", "1231",
				cal.getTime(), DateTime.now().toDate(), false, Status.Part_Time, new String[] {"mummy"});
		userManager.save(user2);
		
		cal = Calendar.getInstance();cal.set(2018, 11, 15);
		User user3 = new User(4l, "koko", "maku", "", "koko.maku@gmail.com", "USA", "123124",
				cal.getTime(), DateTime.now().toDate(), false, Status.Permanent, new String[] {"bhai"});
		userManager.save(user3);
	}


	public void deleteByQuery() {
		QueryBuilder builder = QueryBuilders.matchQuery("firstName", "sambit");
		DeleteQuery query = new DeleteQuery();query.setQuery(builder);
		userManager.deleteUserByQuery(query);
	}
	
	
	public UserManager getUserManager() {
		return userManager;
	}


	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	
}
