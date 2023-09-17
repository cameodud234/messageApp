package com.cam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cam.entity.Message;
import com.cam.repository.MessageRepositoryImpl;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageRepositoryImpl messageRepositoryImpl;

	@Override
	public Message find(String id) {
		return messageRepositoryImpl.find(id);
	}

	@Override
	public List<Message> findAll() {
		return messageRepositoryImpl.findAll();
	}

	@Override
	public void add(Message message) {
		messageRepositoryImpl.add(message);
	}

	@Override
	public void addAll(List<Message> messages) {
		messageRepositoryImpl.addAll(messages);
	}

	@Override
	public void delete(String id) {
		messageRepositoryImpl.delete(id);
	}

}
