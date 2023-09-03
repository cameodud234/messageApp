package com.cam.dao;

import java.util.List;
import java.util.Optional;

import com.cam.entity.User;

public interface UserDao {
	
	public Optional<User> find(User arg);
	
	public List<User> findAll();
	
	public void add(User arg);
	
	public void addAll(List<User> args);
	
	public void update(User arg);
	
	public void delete(User arg);
	
}
