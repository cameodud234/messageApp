package com.cam.dao;

import java.sql.Date;
import java.sql.Types;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cam.entity.User;

public class UserDaoImpl implements UserDao {
	
	private final Logger log = LogManager.getLogger(UserDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Optional<User> find(User arg) {
		
		try {
			String sql = "SELECT * FROM users WHERE users.user_name = ?";
	        String searchFor = arg.getUserName();
	        
	        log.info("searchFor: " + searchFor);
	        
	        List<User> users = jdbcTemplate.query(sql, (rs, rowNum) -> {
	        	String firstName = rs.getString("first_name");
	        	String lastName = rs.getString("last_name");
	        	String userName = rs.getString("user_name");
	        	String email = rs.getString("email");
	        	String password = rs.getString("password");
	        	Date dateOfBirth = rs.getDate("date_of_birth");
	        	String description = rs.getString("description");
	        	return new User(firstName, lastName, userName, email, password, dateOfBirth, description);
	        }, searchFor);
	        
	        log.info("users: " + users);
	        
	        return Optional.ofNullable(users.get(0));
			
		} catch (DataAccessException e) {
			log.error(e.getMessage(), e.getCause(), e.getStackTrace());
		} catch (IndexOutOfBoundsException e) {
			log.error(e.getMessage(), e.getCause(), e.getStackTrace());
		} catch (Exception e) {
			log.error(e.getMessage(), e.getCause(), e.getStackTrace());
		}
		return null;

	}

	@Override
	public List<User> findAll() {
//		String sql = "SELECT * FROM users LIMIT 100";
//		List<User> users = get(sql, "");
		return null;
	}

	@Override
	public void add(User arg) {
		try {
			
		} catch (DataAccessException e) {
			log.error(e.getMessage(), e.getCause(), e.getStackTrace());
		}
		String sql = "INSERT INTO Users (first_name, last_name, user_name, email, password, date_of_birth, description)\n";
		Object[] args = {arg.getFirstName(), arg.getLastName(), arg.getUserName(), arg.getEmail(), arg.getPassword(), arg.getDate()};
		int[] argTypes = {java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.DATE, Types.CLOB};
		jdbcTemplate.update(sql, args, argTypes);
	}

	@Override
	public void addAll(List<User> args) {
		
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
