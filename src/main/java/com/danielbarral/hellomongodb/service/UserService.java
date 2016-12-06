package com.danielbarral.hellomongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielbarral.hellomongodb.model.User;
import com.danielbarral.hellomongodb.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public List<User> list() {
		return userRepository.findAll();
	}

}
