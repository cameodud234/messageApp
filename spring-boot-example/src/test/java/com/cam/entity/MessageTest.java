package com.cam.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

class MessagesTest {

    private Messages messages;

    @BeforeEach
    void setUp() {
        messages = new Messages(
                "1",
                "5",
                "8",
                "Hello, this is a test message.",
                new Timestamp(System.currentTimeMillis()),
                false,
                true
        );
    }

    @Test
    void testGetId() {
        assertEquals("1", messages.getId());
    }

    @Test
    void testGetSenderId() {
        assertEquals("5", messages.getSenderId());
    }

    @Test
    void testGetReceiverId() {
        assertEquals("8", messages.getReceiverId());
    }

    @Test
    void testGetMessage() {
        assertEquals("Hello, this is a test message.", messages.getMessage());
    }

    @Test
    void testGetTimestamp() {
        assertNotNull(messages.getTimestamp());
    }

    @Test
    void testIsRead() {
        assertFalse(messages.isRead());
    }

    @Test
    void testIsActive() {
        assertTrue(messages.isActive());
    }

    @Test
    void testSetId() {
        messages.setId("2");
        assertEquals("2", messages.getId());
    }

    @Test
    void testSetSenderId() {
        messages.setSenderId("newSender");
        assertEquals("newSender", messages.getSenderId());
    }
    
    @Test
    void testSetReceiverId() {
        messages.setReceiverId("newReceiver");
        assertEquals("newReceiver", messages.getReceiverId());
    }

    @Test
    void testSetMessage() {
        messages.setMessage("Updated message.");
        assertEquals("Updated message.", messages.getMessage());
    }

    @Test
    void testSetTimestamp() {
        Timestamp newTimestamp = new Timestamp(System.currentTimeMillis());
        messages.setTimestamp(newTimestamp);
        assertEquals(newTimestamp, messages.getTimestamp());
    }

    @Test
    void testSetRead() {
        messages.setRead(true);
        assertTrue(messages.isRead());
    }

    @Test
    void testSetActive() {
        messages.setActive(false);
        assertFalse(messages.isActive());
    }

    @Test
    void testEquals() {
        Messages sameMessages = new Messages(
                "1",
                "5",
                "8",
                "Hello, this is a test message.",
                new Timestamp(System.currentTimeMillis()),
                false,
                true
        );

        Messages differentMessages = new Messages(
                "2",
                "differentSender",
                "differentReceiver",
                "Different message.",
                new Timestamp(System.currentTimeMillis()),
                true,
                false
        );

        assertTrue(messages.equals(sameMessages));
        assertFalse(messages.equals(differentMessages));
    }

    @Test
    void testHashCode() {
        Messages sameMessages = new Messages(
                "1",
                "5",
                "8",
                "Hello, this is a test message.",
                new Timestamp(System.currentTimeMillis()),
                false,
                true
        );

        assertEquals(messages.hashCode(), sameMessages.hashCode());
    }

    @Test
    void testToString() {
        String expectedToString = "Messages [id=1, senderId=5, receiverId=8, " +
                "message=Hello, this is a test message., timestamp=" + messages.getTimestamp() +
                ", read=false, active=true]";
        assertEquals(expectedToString, messages.toString());
    }
}
