package com.cam.dao;

import java.util.List;

import com.cam.entity.Message;

public interface UserMessageDAO {
	
	public List<Message> findMessages(String userId);	
	
	public List<Message> findSenderReceiverMessages(String senderId, String receiverId);
	
}
