package com.cam.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.cam.entity.User;

@SpringBootTest
@ActiveProfiles("test")
public class TestUserDAOImpl {
	
	private final Logger log = LogManager.getLogger(TestUserDAOImpl.class);
	
	@Autowired
	private UserDAOImpl userDAOImpl;

    
    @Test
    public void testFind() {
    	User user = userDAOImpl.find("1");
    	log.info("user:" + user);
    	LocalDate date = LocalDate.of(1982, 4, 9);
    	Date actualBirthday = Date.valueOf(date);
    	assertEquals(user, new User("Bob", "Ross", "bross234", "bross2@gmail.com", "123", actualBirthday, ""));
    }
    
    @Test 
    public void testFinalAll() {
    	List<User> users = userDAOImpl.findAll();
    	User user1 = new User("Bob", "Ross", "bross234", "bross2@gmail.com", "123", Date.valueOf(LocalDate.of(1982, 4, 9)), "");
    	User user2 = new User("Bob", "Ross", "bross234", "bross2@gmail.com", "123", Date.valueOf(LocalDate.of(1979, 1, 9)), "");
    	List<User> expectedUsers = List.of(user1, user2);
    	users.add(user1);
    	users.add(user2);
    	assertEquals(users, expectedUsers);
    }

}
