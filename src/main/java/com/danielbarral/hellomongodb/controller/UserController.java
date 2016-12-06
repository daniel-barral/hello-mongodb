package com.danielbarral.hellomongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danielbarral.hellomongodb.service.UserService;
import com.danielbarral.hellomongodb.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/save")
	public void save(@RequestParam(value="name", required=true) String name,
			@RequestParam(value="email", required=true) String email) {

		User user = new User();
		user.setEmail(email);
		user.setName(name);

		userService.save(user);
	}

	@RequestMapping("/list")
	public List<User> list() {
		return userService.list();
	}

}
