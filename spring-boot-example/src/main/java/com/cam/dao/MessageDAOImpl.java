package com.cam.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cam.entity.Message;

@Service
public class MessageDAOImpl implements MessageDAO {
	
	private final Logger log = LogManager.getLogger(MessageDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Message find(String id) {
		
		try {
			String sql = "SELECT * FROM messages WHERE message_id = ?";
	        int searchFor = Integer.parseInt(id);
	        
	        List<Message> messages = jdbcTemplate.query(sql, (rs, rowNum) -> {
	        	String messageId = rs.getString("message_id");
				String sender = rs.getString("sender_id");
				String receiver = rs.getString("receiver_id");
				String content = rs.getString("content");
				Timestamp timestamp = rs.getTimestamp("timestamp");
				Boolean read = rs.getBoolean("read");
				Boolean active = rs.getBoolean("active");
				return new Message(messageId, sender, receiver, content, timestamp, read, active);
	        }, searchFor);
	        
	        return messages.size() == 1 ? messages.get(0) : null;
			
		} catch (BadSqlGrammarException e) {
			log.error("Error executing: ", e.getSql());
			log.error("Exception message: ", e.getMessage(), e);
		} catch (DataAccessException e) {
			log.error("Exception message: ", e.getMessage(), e);
		}
		return null;
		
	}
	
	@Override
	public List<Message> findAll() {
		try {
			String sql = "SELECT * FROM messages ORDER BY timestamp DESC";
			List<Message> messages = jdbcTemplate.query(sql, (rs, rowNum) -> {
				String messageId = rs.getString("message_id");
				String sender = rs.getString("sender_id");
				String receiver = rs.getString("receiver_id");
				String content = rs.getString("content");
				Timestamp timestamp = rs.getTimestamp("timestamp");
				Boolean read = rs.getBoolean("read");
				Boolean active = rs.getBoolean("active");
	        	return new Message(messageId, sender, receiver, content, timestamp, read, active);
			});
			log.info(messages);
			return messages;
		} catch (BadSqlGrammarException e) {
			log.error("Error executing: ", e.getSql());
			log.error("Exception message: ", e.getMessage(), e);
		} catch (DataAccessException e) {
			log.error("Exception message: ", e.getMessage(), e);
		}
		
		return null;
	}

	@Override
	public void add(Message message) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addAll(List<Message> messages) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(String id) {
		String sql = "UPDATE messages SET active = ?" + " WHERE message_id = ?";
		Object[] args = { false, Integer.parseInt(id) };
		
		int[] argTypes = {java.sql.Types.BOOLEAN, java.sql.Types.INTEGER};
		
		jdbcTemplate.update(sql, args, argTypes);
	}


}
