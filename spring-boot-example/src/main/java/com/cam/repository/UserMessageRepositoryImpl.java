package com.cam.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cam.dao.UserMessageDAOImpl;
import com.cam.entity.Message;

@Service
public class UserMessageRepositoryImpl implements UserMessageRepository {
	
	@Autowired
	UserMessageDAOImpl userMessageDAO;

	@Override
	public List<Message> findMessages(String userId) {
		return userMessageDAO.findMessages(userId);
	}

	@Override
	public List<Message> findSenderReceiverMessages(String senderId, String receiverId) {
		return userMessageDAO.findSenderReceiverMessages(senderId, receiverId);
	}

}
