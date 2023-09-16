package com.cam.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Timestamp;

class MessageTest {

    private User sender;
    private User receiver;
    private Message message;

    @BeforeEach
    void setUp() {
        sender = new User("1", "John", "Doe", "john.doe", "john@example.com", "password", null, "user", null, null, true);
        receiver = new User("2", "Jane", "Doe", "jane.doe", "jane@example.com", "password", null, "user", null, null, true);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        message = new Message("1", sender, receiver, "Test message", timestamp, false, true);
    }

    @Test
    void messageIdGetter() {
        assertEquals("1", message.getMessageId());
    }

    @Test
    void senderGetter() {
        assertEquals(sender, message.getSender());
    }

    @Test
    void receiverGetter() {
        assertEquals(receiver, message.getReceiver());
    }

    @Test
    void contentGetter() {
        assertEquals("Test message", message.getContent());
    }

    @Test
    void timestampGetter() {
        assertNotNull(message.getTimestamp());
    }

    @Test
    void readGetter() {
        assertFalse(message.isRead());
    }

    @Test
    void activeGetter() {
        assertTrue(message.isActive());
    }

    @Test
    void messageIdSetter() {
        message.setMessageId("2");
        assertEquals("2", message.getMessageId());
    }

    @Test
    void senderSetter() {
        User newSender = new User("3", "Alice", "Smith", "alice.smith", "alice@example.com", "newpassword", null, "user", null, null, true);
        message.setSender(newSender);
        assertEquals(newSender, message.getSender());
    }

    @Test
    void receiverSetter() {
        User newReceiver = new User("4", "Bob", "Johnson", "bob.johnson", "bob@example.com", "newpassword", null, "user", null, null, true);
        message.setReceiver(newReceiver);
        assertEquals(newReceiver, message.getReceiver());
    }

    @Test
    void contentSetter() {
        message.setContent("Updated test message");
        assertEquals("Updated test message", message.getContent());
    }

    @Test
    void timestampSetter() {
        Timestamp newTimestamp = new Timestamp(System.currentTimeMillis() + 1000);
        message.setTimestamp(newTimestamp);
        assertEquals(newTimestamp, message.getTimestamp());
    }

    @Test
    void readSetter() {
        message.setRead(true);
        assertTrue(message.isRead());
    }

    @Test
    void activeSetter() {
        message.setActive(false);
        assertFalse(message.isActive());
    }

    @Test
    void testEquals() {
        Message sameMessage = new Message("1", sender, receiver, "Test message", new Timestamp(System.currentTimeMillis()), false, true);
        Message differentMessage = new Message("2", receiver, sender, "Different message", new Timestamp(System.currentTimeMillis()), true, false);

        assertTrue(message.equals(sameMessage));
        assertFalse(message.equals(differentMessage));
    }

    @Test
    void testHashCode() {
        Message sameMessage = new Message("1", sender, receiver, "Test message", new Timestamp(System.currentTimeMillis()), false, true);

        assertEquals(message.hashCode(), sameMessage.hashCode());
    }

    @Test
    void testToString() {
        String expectedToString = "Message [messageId=1, senderId=1, receiverId=2, content=Test message, timestamp=" + message.getTimestamp() + ", read=false, active=true]";
        assertEquals(expectedToString, message.toString());
    }
}

