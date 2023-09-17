package com.cam.dao;

import java.util.List;

import com.cam.entity.Message;

public interface MessageDAO {
	
	public Message find(String id);
	
	public List<Message> findAll();
	
	public void add(Message message);
	
	public void addAll(List<Message> messages);
	
	public void delete(String id);
	
}