package com.cam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cam.entity.Message;
import com.cam.service.MessageServiceImpl;

@RestController
public class MessageController {
	
	@Autowired
	private MessageServiceImpl messageServiceImpl;
	
	@RequestMapping("/messages") 
	public List<Message> getAllMessages() {
		return messageServiceImpl.findAll();
	}
	
}