package com.cam.repository;

import java.util.List;

import com.cam.entity.Message;

public interface MessageRepository {

	public Message find(String id);
	
	public List<Message> findAll();
	
	public void add(Message message);
	
	public void addAll(List<Message> messages);
	
	public void delete(String id);
	
}
