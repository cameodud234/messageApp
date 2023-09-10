package com.cam.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cam.entity.User;
import com.cam.service.UserServiceImpl;


@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return userServiceImpl.findAll();
	}
	
	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable String id) {
		return userServiceImpl.find(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users") 
	public void addUser(@RequestBody User user) {
		userServiceImpl.add(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable String id) {
		userServiceImpl.update(user, id);
	}
	
}
