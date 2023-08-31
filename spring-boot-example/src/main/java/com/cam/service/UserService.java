package com.cam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cam.entity.User;
import com.cam.repository.UserRepository;

@org.springframework.stereotype.Service

public class UserService implements Service <User> {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> find(User arg) {
		// TODO Auto-generated method stub
		return userRepository.find(arg);
	}

	@Override
	public List<User> findAll(User arg) {
		// TODO Auto-generated method stub
		return userRepository.findAll(arg);
	}

	@Override
	public void add(User arg) {
		
	}

	@Override
	public void add(List<User> args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}