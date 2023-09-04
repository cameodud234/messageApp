package com.cam.service;

import java.util.List;

import com.cam.entity.User;


public interface UserService {
	
	public User find(String id);
	
	public List<User> findAll();
	
	public void add(User arg);
	
	public void addAll(List<User> args);
	
	public void update(User arg);
	
	public void delete(String id);
	
}