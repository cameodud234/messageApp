package com.cam.entity;

import java.sql.Timestamp;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Messages {
	
private final Logger log = LogManager.getLogger(User.class);
	
	private String id;
	private String senderId;
	private String receiverId;
	private String message;
	private Timestamp timestamp;
	private boolean read;
	private boolean active;
	
	
	
	public Messages(String id, String senderId, String receiverId, String message, Timestamp timestamp, boolean read,
			boolean active) {
		this.id = id;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.message = message;
		this.timestamp = timestamp;
		this.read = read;
		this.active = active;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
		return Objects.hash(active, id, message, read, receiverId, senderId, timestamp);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Messages other = (Messages) obj;
		return active == other.active && Objects.equals(id, other.id) && Objects.equals(message, other.message)
				&& read == other.read && Objects.equals(receiverId, other.receiverId)
				&& Objects.equals(senderId, other.senderId) && Objects.equals(timestamp, other.timestamp);
	}
	@Override
	public String toString() {
		return "Messages [id=" + id + ", senderId=" + senderId + ", receiverId=" + receiverId + ", message="
				+ message + ", timestamp=" + timestamp + ", read=" + read + ", active=" + active + "]";
	}
	
	

}
