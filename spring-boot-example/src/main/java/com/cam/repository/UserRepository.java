package com.cam.repository;

import java.util.List;
import java.util.Optional;

import com.cam.entity.User;

public interface UserRepository {
	
	public User getUser(String id);

	public List<User> getAllUsers();

	public void addUser(User arg);

	public void addAllUsers(List<User> args);

	public void updateUser(User arg);

	public void deleteUser(User arg);

}
