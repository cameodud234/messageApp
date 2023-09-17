package com.cam.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

import javax.management.relation.RoleNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class User {
	
	private final Logger log = LogManager.getLogger(User.class);
	
	private String id;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String password;
	private Date dateOfBirth;
	private String role;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private boolean active;
	
	
	public User(String id, String firstName, String lastName, String userName, String email, String password, Date dateOfBirth,
			String role, Timestamp createdAt, Timestamp updatedAt, boolean active) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.role = role;
		this.createdAt = createdAt;
		this.updatedAt = createdAt;
		this.active = active;
	}
	
	public User(User user) {
		id = user.id;
		firstName = user.firstName;
		lastName = user.lastName;
		userName = user.userName;
		email= user.email;
		password = user.password;
		dateOfBirth = user.dateOfBirth;
		role = user.role;
		createdAt = user.createdAt;
		updatedAt = user.updatedAt;
		active = user.active;
	}

	public String getId() {
		return id;
	}
	public void setId(final String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(final Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(final String role) {
		try {
			if(isValidRole(role)) {
				throw new RoleNotFoundException("Role given does not exist...");
			}
			this.role = role;
		} 
		catch (RoleNotFoundException e) {
			log.info(e.getCause() + ", " + e.getMessage());
		}
	}
	
	private boolean isValidRole(final String role) {
		return role != Role.USER.role && role != Role.ADMIN.role && role != Role.DB_ADMIN.role;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(final Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(final Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(final boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOfBirth, createdAt, updatedAt, email, firstName, lastName, password, userName, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(createdAt, createdAt) && Objects.equals(updatedAt, other.updatedAt)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(userName, other.userName) && (active == other.active);
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", email=" + email
				+ ", dateOfBirth=" + dateOfBirth + ", role=" + role + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", isActive=" + active + "]";
	}
	
	
	
}
