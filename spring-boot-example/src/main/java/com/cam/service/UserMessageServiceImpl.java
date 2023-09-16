package com.cam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cam.entity.Message;
import com.cam.repository.UserMessageRepositoryImpl;

@Service
public class UserMessageServiceImpl implements UserMessageService {
	
	@Autowired
	private UserMessageRepositoryImpl userMessageRepositoryImpl;

	@Override
	public List<Message> findMessages(String userId) {
		return userMessageRepositoryImpl.findMessages(userId);
	}

	@Override
	public List<Message> findSenderReceiverMessages(String senderId, String receiverId) {
		return userMessageRepositoryImpl.findSenderReceiverMessages(senderId, receiverId);
	}
	
}
