package com.cam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cam.entity.User;
import com.cam.repository.UserRepositoryImpl;

@org.springframework.stereotype.Service

public interface UserService {
	
	public User find(User arg);

	public List<User> findAll();

	public void add(User arg);

	public void add(List<User> args);

	public void update(User arg);

	public void delete(User arg);
	
}