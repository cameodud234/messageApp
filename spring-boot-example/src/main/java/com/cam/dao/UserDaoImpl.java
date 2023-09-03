package com.cam.dao;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cam.entity.User;

public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private List<User> query(final String sql, final String searchFor) {
		List<User> userList = jdbcTemplate.query(sql, (rs, rowNum) -> {
        	String firstName = rs.getString("first_name");
        	String lastName = rs.getString("last_name");
        	String userName = rs.getString("user_name");
        	String email = rs.getString("email");
        	String password = rs.getString("password");
        	Date dateOfBirth = rs.getDate("date_of_birth");
        	String description = rs.getString("description");
        	return new User(firstName, lastName, userName, email, password, dateOfBirth, description);
        }, searchFor);
		return userList;
	}

	@Override
	public Optional<User> find(User arg) {
		
		String sql = "SELECT * FROM users WHERE users.user_name = ?";
        String username = "cameodud234";
        
        List<User> user = query(sql, username);
        
        return Optional.ofNullable(user.get(0));
        
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM users LIMIT 100";
		List<User> userList = jdbcTemplate.query(sql, (rs, rowNum) -> {
        	String firstName = rs.getString("first_name");
        	String lastName = rs.getString("last_name");
        	String userName = rs.getString("user_name");
        	String email = rs.getString("email");
        	String password = rs.getString("password");
        	Date dateOfBirth = rs.getDate("date_of_birth");
        	String description = rs.getString("description");
        	return new User(firstName, lastName, userName, email, password, dateOfBirth, description);
        });
		
		return userList;
	}

	@Override
	public void add(User arg) {
		
	}

	@Override
	public void addAll(List<User> args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User arg) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
