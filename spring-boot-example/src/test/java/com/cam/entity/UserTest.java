package com.cam.entity;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import java.sql.Timestamp;


public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User(
            "1",
            "John",
            "Doe",
            "johndoe",
            "john@example.com",
            "password",
            Date.valueOf("1990-01-01"),
            "user",
            new Timestamp(System.currentTimeMillis()),
            new Timestamp(System.currentTimeMillis()),
            true
        );
    }
    
    @Test void testGetId() {
    	assertEquals("1", user.getId());
    }
    
    @Test void testGetFirstName() {
    	assertEquals("John", user.getFirstName());
    }
    
    @Test void testGetLastName() {
    	assertEquals("John", user.getLastName());
    }
    
    @Test void testGetUserName() {
    	assertEquals("johndoe", user.getUserName());
    }
    
    @Test void testGetEmail() {
    	assertEquals("john@example.com", user.getEmail());
    }

    @Test void testGetPassword() {
    	assertEquals("password", user.getPassword());
    }
    
    @Test void testGetDateOfBirth() {
    	assertEquals(Date.valueOf("1990-01-01"), user.getDateOfBirth());
    }
    
    @Test void testGetRole() {
    	assertEquals("user", user.getRole());
    }
    
    @Test void testGetCreatedAt() {
    	assertNotNull(user.getCreatedAt());
    }
    
    @Test void testGetUpdatedAt() {
    	assertNotNull(user.getUpdatedAt());
    }
    
    @Test void testIsActive() {
    	assertTrue(user.isActive());
    }

    @Test
    public void testSetters() {
        user.setId("2");
        user.setFirstName("Jane");
        user.setLastName("Smith");
        user.setUserName("janesmith");
        user.setEmail("jane@example.com");
        user.setPassword("newpassword");
        user.setDateOfBirth(Date.valueOf("1995-05-05"));
        user.setRole("admin");
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        user.setActive(false);

        assertEquals("2", user.getId());
        assertEquals("Jane", user.getFirstName());
        assertEquals("Smith", user.getLastName());
        assertEquals("janesmith", user.getUserName());
        assertEquals("jane@example.com", user.getEmail());
        assertEquals("newpassword", user.getPassword());
        assertEquals(Date.valueOf("1995-05-05"), user.getDateOfBirth());
        assertEquals("admin", user.getRole());
        assertNotNull(user.getCreatedAt());
        assertNotNull(user.getUpdatedAt());
        assertFalse(user.isActive());
    }

    @Test
    public void testEqualsAndHashCode() {
        User sameUser = new User(
            "1",
            "John",
            "Doe",
            "johndoe",
            "john@example.com",
            "password",
            Date.valueOf("1990-01-01"),
            "user",
            new Timestamp(System.currentTimeMillis()),
            new Timestamp(System.currentTimeMillis()),
            true
        );

        User differentUser = new User(
            "2",
            "Jane",
            "Smith",
            "janesmith",
            "jane@example.com",
            "newpassword",
            Date.valueOf("1995-05-05"),
            "admin",
            new Timestamp(System.currentTimeMillis()),
            new Timestamp(System.currentTimeMillis()),
            false
        );

        assertTrue(user.equals(sameUser));
        assertTrue(user.hashCode() == sameUser.hashCode());
        assertFalse(user.equals(differentUser));
        assertFalse(user.hashCode() == differentUser.hashCode());
    }

    @Test
    public void testToString() {
        String expectedToString = "User [firstName=John, lastName=Doe, userName=johndoe, email=john@example.com, dateOfBirth=1990-01-01, role=user, createdAt=" + user.getCreatedAt() + ", updatedAt=" + user.getUpdatedAt() + ", isActive=true]";
        assertEquals(expectedToString, user.toString());
    }
    
    
    @Test
    public void testSetRoleValid() {
        // Test setting a valid role
        user.setRole(Role.ADMIN.role);
        assertEquals(Role.ADMIN.role, user.getRole());
    }
    
}


