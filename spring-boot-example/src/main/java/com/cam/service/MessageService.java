package com.cam.service;

import java.util.List;

import com.cam.entity.Message;

public interface MessageService {
	
	public Message find(String senderId, String receiverId);
	
	public List<Message> findAll();
	
	public void add(Message message);
	
	public void addAll(List<Message> messages);
	
	public void delete(String senderId, String receiverId);
	
}