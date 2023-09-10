package com.cam.dao;

import java.sql.Date;
import java.sql.SQLException;
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
public class UserDAOImpl implements UserDAO {
	
	private final Logger log = LogManager.getLogger(UserDAOImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User find(String id) {
		
		try {
			String sql = "SELECT * FROM users WHERE users.user_id = ?";
	        int searchFor = Integer.parseInt(id);
	        
	        List<User> users = jdbcTemplate.query(sql, (rs, rowNum) -> {
	        	String user_id = rs.getString("user_id");
	        	String firstName = rs.getString("first_name");
	        	String lastName = rs.getString("last_name");
	        	String userName = rs.getString("user_name");
	        	String email = rs.getString("email");
	        	String password = rs.getString("password");
	        	Date dateOfBirth = rs.getDate("date_of_birth");
	        	String description = rs.getString("description");
	        	boolean isActive = rs.getBoolean("active");
	        	return new User(user_id, firstName, lastName, userName, email, password, dateOfBirth, description, isActive);
	        }, searchFor); 
	        
	        
	        return users.size() == 1 ? users.get(0) : null;
			
		} catch (DataAccessException e) {
			log.error(e.getMessage(), e.getCause(), e.getStackTrace());
		}
		return null;

	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM users LIMIT 100";
		List<User> users = jdbcTemplate.query(sql, (rs, rowNum) -> {
			String user_id = rs.getString("user_id");
        	String firstName = rs.getString("first_name");
        	String lastName = rs.getString("last_name");
        	String userName = rs.getString("user_name");
        	String email = rs.getString("email");
        	String password = rs.getString("password");
        	Date dateOfBirth = rs.getDate("date_of_birth");
        	String description = rs.getString("description");
        	boolean isActive = rs.getBoolean("active");
        	return new User(user_id, firstName, lastName, userName, email, password, dateOfBirth, description, isActive);
		});
		log.info(users.size());
		return users;
	}

	@Override
	public void add(User arg) {
		try {
//			this.jdbcTemplate.update(
//					"insert into t_actor (first_name, last_name) values (?, ?)",
//					"Leonor", "Watling");
//			String sql = "INSERT INTO Users (first_name, last_name, user_name, email, password, date_of_birth, description)\n";
//			Object[] args = {arg.getFirstName(), arg.getLastName(), arg.getUserName(), arg.getEmail(), arg.getPassword(), arg.getDate()};
//			int[] argTypes = {java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.DATE, Types.CLOB};
//			jdbcTemplate.update(sql, args, argTypes);
			
		} catch (DataAccessException e) { 
			log.error(e.getMessage(), e.getCause(), e.getStackTrace());
		}
	}

	@Override
	public void addAll(List<User> args) {
		
	}

	@Override
	public void update(User arg) {
		try {
//			String sql = "Update users set (first_name, last_name, user_name, email, password, date_of_birth, description)\n";
//			Object[] args = {arg.getFirstName(), arg.getLastName(), arg.getUserName(), arg.getEmail(), arg.getPassword(), arg.getDate()};
//			int[] argTypes = {java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.DATE, Types.CLOB};
//			jdbcTemplate.update(sql, args, argTypes);
		} catch (DataAccessException e) {
			log.error(e.getMessage(), e.getCause(), e.getStackTrace());
		}
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	public int getCountOfEmployees() {
		String sql = "SELECT COUNT(*) FROM users";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		log.info("user count: " + count);
		return count;
	}
	
	
}
