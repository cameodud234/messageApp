package com.cam.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testEquals() {
        User user1 = new User("1", "John", "Doe", "johndoe", "johndoe@example.com", "password", new Date(1234567890L), "Description", true);
        User user2 = new User("1", "John", "Doe", "johndoe", "johndoe@example.com", "password", new Date(1234567890L), "Description", true);
        User user3 = new User("2", "Jane", "Smith", "janesmith", "janesmith@example.com", "password123", new Date(9876543210L), "Description", false);

        // Test equality between user1 and user2 (they have the same attributes)
        assertTrue(user1.equals(user2));

        // Test equality between user1 and user3 (they have different IDs)
        assertFalse(user1.equals(user3));
    }

    @Test
    public void testHashCode() {
        User user1 = new User("1", "John", "Doe", "johndoe", "johndoe@example.com", "password", new Date(1234567890L), "Description", true);
        User user2 = new User("1", "John", "Doe", "johndoe", "johndoe@example.com", "password", new Date(1234567890L), "Description", true);
        User user3 = new User("2", "Jane", "Smith", "janesmith", "janesmith@example.com", "password123", new Date(9876543210L), "Description", false);

        // Test that the hashCode method returns the same value for equal objects
        assertTrue(user1.hashCode() == user2.hashCode());
        
        // Test to ensure hashCode method returns different value for non-equal objects.
        assertFalse(user1.hashCode() == user3.hashCode());
    }
}
