package com.cam.repository;

import java.util.List;

import com.cam.entity.Message;

public interface UserMessageRepository {

	public List<Message> findMessages(String userId);	
	
	public List<Message> findSenderReceiverMessages(String senderId, String receiverId);
	
}
