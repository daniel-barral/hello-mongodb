package com.danielbarral.hellomongodb.service;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.danielbarral.hellomongodb.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void saveTest() {
		
		User user = new User();
		user.setName("John Doe");
		user.setEmail("test@example.com");
		
		user = userService.save(user);
		
		User returnedUser = userService.find(user.getId());
		
		assertEquals("John Doe", returnedUser.getName());
		assertEquals("test@example.com", returnedUser.getEmail());
		
	}

}
