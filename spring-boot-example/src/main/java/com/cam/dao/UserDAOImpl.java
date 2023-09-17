package com.cam.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cam.entity.Role;
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
	        	String role = rs.getString("role");
	        	Timestamp createdAt = rs.getTimestamp("created_at");
	        	Timestamp updatedAt = rs.getTimestamp("updated_at");
	        	boolean isActive = rs.getBoolean("active");
	        	return new User(user_id, firstName, lastName, userName, email, password, dateOfBirth, role, createdAt, updatedAt, isActive);
	        }, searchFor); 
	        
	        
	        return users.size() == 1 ? users.get(0) : null;
			
		} catch (BadSqlGrammarException e) {
			log.error("Error executing: ", e.getSql());
			log.error("Exception message: ", e.getMessage(), e);
		} catch (DataAccessException e) {
			log.error("Exception message: ", e.getMessage(), e);
		}
		return null;

	}

	@Override
	public List<User> findAll() {
		try {
			String sql = "SELECT * FROM users";
			List<User> users = jdbcTemplate.query(sql, (rs, rowNum) -> {
				String user_id = rs.getString("user_id");
	        	String firstName = rs.getString("first_name");
	        	String lastName = rs.getString("last_name");
	        	String userName = rs.getString("user_name");
	        	String email = rs.getString("email");
	        	String password = rs.getString("password");
	        	Date dateOfBirth = rs.getDate("date_of_birth");
	        	String role = rs.getString("role");
	        	Timestamp createdAt = rs.getTimestamp("created_at");
	        	Timestamp updatedAt = rs.getTimestamp("updated_at");
	        	boolean isActive = rs.getBoolean("active");
	        	return new User(user_id, firstName, lastName, userName, email, password, dateOfBirth, role, createdAt, updatedAt, isActive);
			});
			log.info(users.size());
			return users;
		} catch (BadSqlGrammarException e) {
			log.error("Error executing: ", e.getSql());
			log.error("Exception message: ", e.getMessage(), e);
		} catch (DataAccessException e) {
			log.error("Exception message: ", e.getMessage(), e);
		}
		
		return null;
	}

	@Override
	public void add(User user) {
		try {
			String sql = "INSERT INTO users (first_name, last_name, user_name, email, password, date_of_birth, role, active) values (?, ?, ?, ?, ?, ?, ?, ?)";
			Object[] args = {user.getFirstName(), user.getLastName(), user.getUserName(), 
					user.getEmail(), user.getPassword(), user.getDateOfBirth(), user.getRole(), user.isActive()};
			log.info(args.toString());
			int[] argTypes = {java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, 
					java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.DATE, java.sql.Types.VARCHAR, 
						java.sql.Types.TIMESTAMP_WITH_TIMEZONE, java.sql.Types.TIMESTAMP_WITH_TIMEZONE, java.sql.Types.BOOLEAN};
			jdbcTemplate.update(sql, args, argTypes);
			
		} catch (BadSqlGrammarException e) {
			log.error("Error executing: ", e.getSql());
			log.error("Exception message: ", e.getMessage(), e);
		} catch (DataAccessException e) {
			log.error("Exception message: ", e.getMessage(), e);
		}
	}

	@Override
	public void addAll(List<User> args) {
		
	}

	@Override
	public void update(User user, String id) {
		try {
			String sql = "UPDATE users SET first_name = ?, last_name = ?, user_name = ?, email = ?, password = ?, date_of_birth = ?, role = ?, active = ?"
					+ " WHERE user_id = ?";
			Object[] args = {user.getFirstName(), user.getLastName(), user.getUserName(), 
					user.getEmail(), user.getPassword(), user.getDateOfBirth(), user.getRole(), user.isActive(), Integer.parseInt(id)};
			
			int[] argTypes = {java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, 
					java.sql.Types.VARCHAR, java.sql.Types.VARCHAR, java.sql.Types.DATE, java.sql.Types.VARCHAR, 
						java.sql.Types.TIMESTAMP_WITH_TIMEZONE, java.sql.Types.TIMESTAMP_WITH_TIMEZONE, java.sql.Types.BOOLEAN};
			jdbcTemplate.update(sql, args, argTypes);
		} catch (BadSqlGrammarException e) {
			log.error("Error executing: ", e.getSql());
			log.error("Exception message: ", e.getMessage(), e);
		} catch (DataAccessException e) {
			log.error("Exception message: ", e.getMessage(), e);
		}
	}

	@Override
	public void delete(String id) {
			try {
				String sql = "UPDATE users SET active = ?" + " WHERE user_id = ?";
				Object[] args = { false, Integer.parseInt(id) };
				
				int[] argTypes = {java.sql.Types.BOOLEAN, java.sql.Types.INTEGER};
				jdbcTemplate.update(sql, args, argTypes);
				
			} catch (BadSqlGrammarException e) {
				log.error("Error executing: ", e.getSql());
				log.error("Exception message: ", e.getMessage(), e);
			} catch (DataAccessException e) {
				log.error("Exception message: ", e.getMessage(), e);
			}
	}

	public int getCountOfEmployees() {
		try {
			String sql = "SELECT COUNT(*) FROM users";
			int count = jdbcTemplate.queryForObject(sql, Integer.class);
			return count;
		} catch (BadSqlGrammarException e) {
			log.error("Error executing: ", e.getSql());
			log.error("Exception message: ", e.getMessage(), e);
		} catch (DataAccessException e) {
			log.error("Exception message: ", e.getMessage(), e);
		}
		return Integer.MIN_VALUE;
	}
	
	
}
