package com.cam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cam.entity.Message;
import com.cam.service.UserMessageServiceImpl;

@RestController
public class UserMessageController {
	
	@Autowired
	private UserMessageServiceImpl userMessageServiceImpl;
	
	@RequestMapping(method=RequestMethod.GET, value="/messages/{sender_id}/{receiver_id}")
	public List<Message> getMessages(@PathVariable String sender_id, @PathVariable String receiver_id) {
		return userMessageServiceImpl.findSenderReceiverMessages(sender_id, receiver_id);
	}
	
}