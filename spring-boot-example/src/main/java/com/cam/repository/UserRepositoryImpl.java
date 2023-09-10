package com.cam.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cam.dao.UserDAOImpl;
import com.cam.entity.User;

@Service
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	private UserDAOImpl userDaoImpl;
	
	@Override
	public User find(String id) {
		return userDaoImpl.find(id);
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
	public void update(User user, String id) {
		userDaoImpl.update(user, id);
	}

	@Override
	public void delete(String id) {
		userDaoImpl.delete(id);
	}
	
}
