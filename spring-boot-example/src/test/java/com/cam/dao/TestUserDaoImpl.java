package com.cam.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cam.entity.User;

@ExtendWith(MockitoExtension.class)
public class TestUserDaoImpl {
	
	private final Logger log = LogManager.getLogger(TestUserDaoImpl.class);

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private UserDAOImpl userDaoImpl;

    @Test
    public void testFind() {
        // Mock the behavior of the JdbcTemplate queryForObject method
        String sql = "SELECT * FROM users WHERE users.user_id = ?";
        int id = 1;

        // Create a User object for testing
        User user = new User("Cameron", "Dudley", "cameodud234", "john@example.com", "password", null, null);

        // Mock the queryForObject method to return the user when called with the specified SQL and argument
        when(jdbcTemplate.queryForObject(eq(sql), any(RowMapper.class), eq(id)))
            .thenReturn(user);

        // Call the find method and verify the result
        User result = userDaoImpl.find("1");

        // Perform assertions to check if the expected user was found
        assertEquals(user, result);
    }
}
