package com.cam.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cam.dao.UserMessageDAOImpl;
import com.cam.entity.Message;

@Service
public class UserMessageRepositoryImpl implements UserMessageRepository {
	
	@Autowired
	UserMessageDAOImpl userMessageDAOImpl;

	@Override
	public List<Message> findMessages(String userId) {
		return userMessageDAOImpl.findMessages(userId);
	}

	@Override
	public List<Message> findSenderReceiverMessages(String senderId, String receiverId) {
		return userMessageDAOImpl.findSenderReceiverMessages(senderId, receiverId);
	}

	@Override
	public void addSenderReceiverMessage(Message message) {
		userMessageDAOImpl.addSenderReceiverMessage(message);
	}

}
