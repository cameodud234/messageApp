package com.cam.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.util.ReflectionTestUtils;

import com.cam.entity.User;

@ExtendWith(MockitoExtension.class)
public class TestUserDAOImpl {
	
	private final Logger log = LogManager.getLogger(TestUserDAOImpl.class);

    @Mock
    private JdbcTemplate jdbcTemplate;

//    @InjectMocks
//    private UserDAOImpl userDaoImpl;
    
    @Test
    public void testFind() {
    	UserDAOImpl userDAOImpl = new UserDAOImpl();
        ReflectionTestUtils.setField(userDAOImpl, "jdbcTemplate", jdbcTemplate);
        Mockito.when(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users", Integer.class))
          .thenReturn(128260);

        assertEquals(128260, userDAOImpl.getCountOfEmployees());
    }

//    @Test
//    public void testFind() {
//        // Mock the behavior of the JdbcTemplate queryForObject method
//        String sql = "SELECT * FROM users WHERE users.user_id = ?";
//        int id = 1;
//
//        Date date = new Date(1993, 05, 21);
//        // Create a User object for testing
//        User user = new User("Cameron", "Dudley", "cameodud234", "camerondudley2@gmail.com", "qui234", date, "");
//        
//        ReflectionTestUtils.setField(userDaoImpl, "jdbcTemplate", jdbcTemplate);
//        // Mock the queryForObject method to return the user when called with the specified SQL and argument
//        Mockito.when(jdbcTemplate.queryForObject(sql, User.class))
//        .thenReturn(user);
//
//        // Call the find method and verify the result
//        User result = userDaoImpl.find("1");
//
//        // Perform assertions to check if the expected user was found
//        assertEquals(user, result);
//    }
}
