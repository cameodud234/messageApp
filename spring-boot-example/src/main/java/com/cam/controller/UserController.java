package com.cam.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cam.entity.User;
import com.cam.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@RequestMapping("/users/{username}")
	public Optional<User> getUser(@PathVariable String username) {
		User user = new User("Cameron", "Dudley", username, "camerondudley2@gmail.com", null, null, null);
		return userServiceImpl.find(user);
	}
	
}
