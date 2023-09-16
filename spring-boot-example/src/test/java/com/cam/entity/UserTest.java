package com.cam.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import org.junit.jupiter.api.Test;
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
    	assertEquals("Doe", user.getLastName());
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
    public void testSetId() {
        user.setId("2");
        assertEquals("2", user.getId());
    }

    @Test
    public void testSetFirstName() {
        user.setFirstName("Jane");
        assertEquals("Jane", user.getFirstName());
    }

    @Test
    public void testSetLastName() {
        user.setLastName("Smith");
        assertEquals("Smith", user.getLastName());
    }

    @Test
    public void testSetUserName() {
        user.setUserName("janesmith");
        assertEquals("janesmith", user.getUserName());
    }

    @Test
    public void testSetEmail() {
        user.setEmail("jane@example.com");
        assertEquals("jane@example.com", user.getEmail());
    }

    @Test
    public void testSetPassword() {
        user.setPassword("newpassword");
        assertEquals("newpassword", user.getPassword());
    }

    @Test
    public void testSetDateOfBirth() {
        user.setDateOfBirth(Date.valueOf("1995-05-05"));
        assertEquals(Date.valueOf("1995-05-05"), user.getDateOfBirth());
    }

    @Test
    public void testSetRole() {
        user.setRole("admin");
        assertEquals("admin", user.getRole());
    }

    @Test
    public void testSetCreatedAt() {
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        user.setCreatedAt(createdAt);
        assertEquals(createdAt, user.getCreatedAt());
    }

    @Test
    public void testSetUpdatedAt() {
        Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
        user.setUpdatedAt(updatedAt);
        assertEquals(updatedAt, user.getUpdatedAt());
    }

    @Test
    public void testSetActive() {
        user.setActive(false);
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
        user.setRole(Role.ADMIN.role);
        assertEquals(Role.ADMIN.role, user.getRole());
    }
    
}


