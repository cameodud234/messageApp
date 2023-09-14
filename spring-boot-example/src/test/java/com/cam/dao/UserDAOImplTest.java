package com.cam.dao;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.cam.entity.User;

@SpringBootTest
@ActiveProfiles("test")
public class UserDAOImplTest {
	
	private final Logger log = LogManager.getLogger(UserDAOImplTest.class);
	
	@Autowired
	private UserDAOImpl userDAOImpl;

    
    @Test
    public void testFind() {
    	User user = userDAOImpl.find("1");
    	log.info("user:" + user);
    	LocalDate date = LocalDate.of(1982, 4, 9);
    	Date actualBirthday = Date.valueOf(date);
    	assertEquals(user, new User("1","Bob", "Ross", "bross234", "bross2@gmail.com", "123", actualBirthday, "", true));
    }

}
