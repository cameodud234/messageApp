package com.cam.repository;

import java.util.List;

public interface UserRepository <User> {
	
	public List<User> find(User arg);
	
	public List<User> findAll();
	
	public void add(User arg);
	
	public void add(List<User> args);
	
	public void update(User arg);
	
	public void delete(int id);

}
