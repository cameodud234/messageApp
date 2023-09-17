package com.cam.entity;

import java.sql.Timestamp;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Timestamp;

public class Message {
	
	private final Logger log = LogManager.getLogger(Message.class);
	
    private String messageId;
    private String senderId;
    private String receiverId;
    private String content;
    private Timestamp timestamp;
    private boolean read;
    private boolean active;


    public Message(String messageId, String senderId, String receiverId, String content, Timestamp timestamp, boolean read, boolean active) {
    	this.messageId = messageId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.timestamp = timestamp;
        this.read = read;
        this.active = active;
    }


	public String getMessageId() {
		return messageId;
	}


	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}


	public String getSenderId() {
		return senderId;
	}


	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}


	public String getReceiverId() {
		return receiverId;
	}


	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Timestamp getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}


	public boolean isRead() {
		return read;
	}


	public void setRead(boolean read) {
		this.read = read;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	@Override
	public int hashCode() {
		return Objects.hash(active, content, messageId, read, receiverId, senderId, timestamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return active == other.active && Objects.equals(content, other.content)
				&& Objects.equals(messageId, other.messageId) && read == other.read
				&& Objects.equals(receiverId, other.receiverId) && Objects.equals(senderId, other.senderId)
				&& Objects.equals(timestamp, other.timestamp);
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", senderId=" + senderId + ", receiverId=" + receiverId + ", content="
				+ content + ", timestamp=" + timestamp + ", read=" + read + ", active=" + active + "]";
	}
    
	
    
    
    
}
