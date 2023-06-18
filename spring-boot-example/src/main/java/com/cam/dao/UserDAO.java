package com.cam.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cam.model.User;

public class UserDAO implements DAO<User> {
	
	List<User> users = new ArrayList<>();
	
	public UserDAO() {
		users.add(new User("Cameron", 30, "cdudle93@gmail.com"));
		users.add(new User("Cam", 29, "camerondudley2@gmail.com"));
		users.add(new User("Matt", 12, "mattyKnows123@nyit.edu"));
	}

	@Override
	public Optional<User> get(long id) {
		return Optional.ofNullable(users.get((int) id));
	}

	@Override
	public List<User> getAll() {
		return new ArrayList<User>(users);
	}

	@Override
	public void save(User user) {
		users.add(user);
	}

	@Override
	public void update(User user) {
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
	}

}
