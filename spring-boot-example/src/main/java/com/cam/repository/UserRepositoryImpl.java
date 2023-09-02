package com.cam.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cam.entity.User;

public class UserRepositoryImpl implements UserRepository<User> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<User> find(User arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(User arg) {
		// TODO Auto-generated method stub
	}

	@Override
	public void add(List<User> args) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(User arg) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
	}

	
	
}
