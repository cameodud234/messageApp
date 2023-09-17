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

public class MessageDAOImpl implements MessageDAO {
	
	private final Logger log = LogManager.getLogger(MessageDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Message find(String id) {
		
//		try {
//			String sql = "SELECT *\n"
//					+ "FROM messages\n"
//					+ "WHERE messages_id = ?";
//	        int searchFor = Integer.parseInt(id);
//	        
//	        UserDAOImpl userDAOImpl = new UserDAOImpl();
//	        
//	        List<Message> messages = jdbcTemplate.query(sql, (rs, rowNum) -> {
//	        	String messageId = rs.getString("message_id");
//				User sender = userDAOImpl.find(id);
//				User receiver = null;
//				String content = rs.getString("content");
//				Timestamp timestamp = rs.getTimestamp("timestamp");
//				Boolean read = rs.getBoolean("read");
//				Boolean active = rs.getBoolean("active");
//				return new Message(messageId, sender, receiver, content, timestamp, read, active);
//	        }, searchFor);
//	        
//	        return messages.size() == 1 ? messages.get(0) : null;
//			
//		} catch (DataAccessException e) {
//			log.error(e.getMessage(), e.getCause(), e.getStackTrace());
//		}
		return null;
		
	}

	@Override
	public List<Message> findAll() {
		// TODO Auto-generated method stub
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
