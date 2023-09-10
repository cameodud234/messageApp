package com.cam.repository;

import java.util.List;

import com.cam.entity.User;

public interface UserRepository {
	
	public User find(String id);
	
	public List<User> findAll();
	
	public void add(User user);
	
	public void addAll(List<User> users);
	
	public void update(User user, String id);
	
	public void delete(String id);

}
