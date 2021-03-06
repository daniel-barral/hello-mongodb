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

	public User save(User user) {
		return userRepository.save(user);
	}

	public List<User> list() {
		return userRepository.findAll();
	}
	
	public User find(String id) {
		return userRepository.findOne(id);
	}
	
	public User findByName(String name) {
		return userRepository.findByName(name);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
