package com.cam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cam.entity.User;
import com.cam.repository.UserRepositoryImpl;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepositoryImpl userRepositoryImpl;

	@Override
	public User find(String id) {
		return userRepositoryImpl.find(id);
	}

	@Override
	public List<User> findAll() {
		return userRepositoryImpl.findAll();
	}

	@Override
	public void add(User arg) {
		userRepositoryImpl.update(arg);
	}

	@Override
	public void addAll(List<User> args) {
		userRepositoryImpl.addAll(args);
	}

	@Override
	public void update(User arg) {
		userRepositoryImpl.update(arg);
	}

	@Override
	public void delete(String id) {
		userRepositoryImpl.delete(id);
	}

}
