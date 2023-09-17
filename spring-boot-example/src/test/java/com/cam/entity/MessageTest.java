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

    private Message message;

    @BeforeEach
    void setUp() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        message = new Message("1", "3", "6", "Test message", timestamp, false, true);
    }

    @Test
    void messageIdGetter() {
        assertEquals("1", message.getMessageId());
    }

    @Test
    void senderGetter() {
        assertEquals("3", message.getSenderId());
    }

    @Test
    void receiverGetter() {
        assertEquals("6", message.getReceiverId());
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
        message.setSenderId("9");
        assertEquals("9", message.getSenderId());
    }

    @Test
    void receiverSetter() {
        message.setReceiverId("10");
        assertEquals("10", message.getReceiverId());
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
        Message sameMessage = new Message("1", "3", "6", "Test message", new Timestamp(System.currentTimeMillis()), false, true);
        Message differentMessage = new Message("2", "11", "13", "Different message", new Timestamp(System.currentTimeMillis()), true, false);

        assertTrue(message.equals(sameMessage));
        assertFalse(message.equals(differentMessage));
    }

    @Test
    void testHashCode() {
        Message sameMessage = new Message("1", "3", "6", "Test message", new Timestamp(System.currentTimeMillis()), false, true);

        assertEquals(message.hashCode(), sameMessage.hashCode());
    }

    @Test
    void testToString() {
        String expectedToString = "Message [messageId=1, senderId=3, receiverId=6, content=Test message, timestamp=" + message.getTimestamp() + ", read=false, active=true]";
        assertEquals(expectedToString, message.toString());
    }
}

