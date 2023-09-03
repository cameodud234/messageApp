package com.cam.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cam.dao.UserDaoImpl;
import com.cam.entity.User;

public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	@Override
	public Optional<User> find(User arg) {
		return userDaoImpl.find(arg);
	}

	@Override
	public List<User> findAll() {
		return userDaoImpl.findAll();
	}

	@Override
	public void add(User arg) {
		userDaoImpl.add(arg);
	}

	@Override
	public void addAll(List<User> args) {
		userDaoImpl.addAll(args);
	}

	@Override
	public void update(User arg) {
		userDaoImpl.update(arg);
	}

	@Override
	public void delete(User arg) {
		userDaoImpl.delete(arg);
	}
	
}
