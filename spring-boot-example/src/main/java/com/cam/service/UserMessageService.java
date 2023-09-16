package com.cam.service;

import java.util.List;

import com.cam.entity.Message;

public interface UserMessageService {
	
	public List<Message> findMessages(String userId);	
	
	public List<Message> findSenderReceiverMessages(String senderId, String receiverId);

}
