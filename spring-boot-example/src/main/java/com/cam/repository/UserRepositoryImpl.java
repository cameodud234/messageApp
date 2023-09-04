package com.cam.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cam.dao.UserDaoImpl;
import com.cam.entity.User;

@Service
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	@Override
	public User getUser(String id) {
		return userDaoImpl.getUser(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userDaoImpl.getAllUsers();
	}

	@Override
	public void addUser(User arg) {
		userDaoImpl.addUser(arg);
	}

	@Override
	public void addAllUsers(List<User> args) {
		userDaoImpl.addAllUsers(args);
	}

	@Override
	public void updateUser(User arg) {
		userDaoImpl.updateUser(arg);
	}

	@Override
	public void deleteUser(User arg) {
		userDaoImpl.deleteUser(arg);
	}
	
}
