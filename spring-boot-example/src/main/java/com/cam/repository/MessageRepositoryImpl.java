package com.cam.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cam.dao.MessageDAOImpl;
import com.cam.entity.Message;

@Service
public class MessageRepositoryImpl implements MessageRepository {
	
	@Autowired
	MessageDAOImpl messageDAOImpl;

	@Override
	public Message find(String id) {
		return messageDAOImpl.find(id);
	}

	@Override
	public List<Message> findAll() {
		return messageDAOImpl.findAll();
	}

	@Override
	public void add(Message message) {
		messageDAOImpl.add(message);
	}

	@Override
	public void addAll(List<Message> messages) {
		messageDAOImpl.addAll(messages);
	}

	@Override
	public void delete(String id) {
		messageDAOImpl.delete(id);
	}
	
}