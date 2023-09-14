package com.cam.entity;

public enum Role {

	USER("user"),
	ADMIN("admin"),
	DB_ADMIN("db_admin");
	
	public final String role;
	
	private Role(String role) {
		this.role = role; 
	}
	
}
