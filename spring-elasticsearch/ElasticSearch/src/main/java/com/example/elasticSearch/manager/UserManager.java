package com.example.elasticSearch.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.DeleteQuery;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.elasticSearch.model.User;
import com.example.elasticSearch.repository.UserRepository;

@Component
@Transactional
public class UserManager {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ElasticsearchTemplate template;
	
	public void save(User user) {
		userRepository.save(user);
	}

	public void deleteUserByQuery(DeleteQuery query) {
		template.delete(query, User.class);
	}
	
	public void updateUser(UpdateQuery query) {
		template.update(query);
	}
	public UserRepository getUserRepository() {
		return userRepository;
	}


	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
}
