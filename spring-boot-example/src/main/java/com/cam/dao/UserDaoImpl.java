package com.cam.dao;

import java.sql.Date;
import java.sql.Types;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cam.entity.User;

@Service
public class UserDaoImpl implements UserDao {
	
	private final Logger log = LogManager.getLogger(UserDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User getUser(String id) {
		
		try {
			String sql = "SELECT * FROM users WHERE users.user_id = ?";
	        int searchFor = Integer.parseInt(id);
	        
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
	        
	        
	        return users.size() == 1 ? users.get(0) : null;
			
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
	public List<User> getAllUsers() {
		String sql = "SELECT * FROM users LIMIT 100";
		List<User> users = jdbcTemplate.query(sql, (rs, rowNum) -> {
			String firstName = rs.getString("first_name");
        	String lastName = rs.getString("last_name");
        	String userName = rs.getString("user_name");
        	String email = rs.getString("email");
        	String password = rs.getString("password");
        	Date dateOfBirth = rs.getDate("date_of_birth");
        	String description = rs.getString("description");
        	return new User(firstName, lastName, userName, email, password, dateOfBirth, description);
		});
		log.info(users.size());
		return users;
	}

	@Override
	public void addUser(User arg) {
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
	public void addAllUsers(List<User> args) {
		
	}

	@Override
	public void updateUser(User arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User arg) {
		// TODO Auto-generated method stub
		
	}
	
	
}
