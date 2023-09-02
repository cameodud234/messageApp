package com.cam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cam.entity.User;
import com.cam.repository.UserRepositoryImpl;

public class UserServiceImpl {
	
	@Autowired
	private UserRepositoryImpl userRepository;
	
	

}
