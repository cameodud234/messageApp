package com.cam.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cam.entity.Message;
import com.cam.entity.User;

public class UserMessageDAOImpl implements UserMessageDAO {
	
	private final Logger log = LogManager.getLogger(UserMessageDAOImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Message> findMessages(String userId) {
		return null;
	}

	@Override
	public List<Message> findSenderReceiverMessages(String senderId, String receiverId) {
		try {
			
			String sql = "SELECT messages.message_id, messages.content, messages.timestamp, messages.read, messages.active\n"
					+ "FROM messages "
					+ "JOIN users ON messages.sender_id = ? AND messages.receiver_id = ?";
			
			Object[] args = { senderId, receiverId };
			int[] argTypes = { java.sql.Types.INTEGER, java.sql.Types.INTEGER };
			UserDAOImpl userDAOImpl = new UserDAOImpl();
			
			List<Message> messages = jdbcTemplate.query(sql, args, argTypes, (rs, rowNum) -> {
				String messageId = rs.getString("message_id");
				User sender = userDAOImpl.find(senderId);
				User receiver = userDAOImpl.find(receiverId);
				String content = rs.getString("content");
				Timestamp timestamp = rs.getTimestamp("timestamp");
				Boolean read = rs.getBoolean("read");
				Boolean active = rs.getBoolean("active");
				return new Message(messageId, sender, receiver, content, timestamp, read, active);
			});
			
			return messages;
			
			
		} catch (DataAccessException e) {
			log.info(e.getMessage() + ", " +  e.getCause());
		} 
		return null;
	}

}
