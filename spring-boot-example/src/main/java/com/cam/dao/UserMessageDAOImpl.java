package com.cam.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cam.entity.Message;
import com.cam.entity.User;

@Service
public class UserMessageDAOImpl implements UserMessageDAO {
	
	private final Logger log = LogManager.getLogger(UserMessageDAOImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Message> findMessages(String userId) {
		try {
			
			String sql = "SELECT messages.*\n"
					+ "FROM messages\n"
					+ "INNER JOIN users ON messages.sender_id = ?";
			int searchFor = Integer.parseInt(userId);
			
			
			
		} catch (DataAccessException e) {
			log.info(e.getMessage() + ", " + e.getCause());
		}
		
		return null;
		
	}

	@Override
	public List<Message> findSenderReceiverMessages(String senderId, String receiverId) {
		try {
			
			String sql = "SELECT DISTINCT messages.* "
					+ "FROM messages "
					+ "INNER JOIN users ON messages.sender_id = ? AND messages.receiver_id = ? "
					+ "OR messages.sender_id = ? AND messages.receiver_id = ? "
					+ "ORDER BY messages.timestamp DESC;";
			
			Object[] args = { senderId, receiverId, receiverId, senderId };
			int[] argTypes = { java.sql.Types.INTEGER, java.sql.Types.INTEGER, java.sql.Types.INTEGER, java.sql.Types.INTEGER };
			UserDAOImpl userDAOImpl = new UserDAOImpl();
			
			List<Message> messages = jdbcTemplate.query(sql, args, argTypes, (rs, rowNum) -> {
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
			
			
		} catch (DataAccessException e) {
			log.info(e.getMessage() + ", " +  e.getCause());
		} 
		return null;
	}

}
