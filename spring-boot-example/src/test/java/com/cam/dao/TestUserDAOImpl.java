package com.cam.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;


public class TestUserDAOImpl {
	
	private final Logger log = LogManager.getLogger(TestUserDAOImpl.class);

    @Mock
    private JdbcTemplate jdbcTemplate;

    
    @Test
    public void testFind() {
    	UserDAOImpl userDAOImpl = new UserDAOImpl();
        ReflectionTestUtils.setField(userDAOImpl, "jdbcTemplate", jdbcTemplate);
        Mockito.when(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users", Integer.class))
          .thenReturn(128260);

        assertEquals(128260, userDAOImpl.getCountOfEmployees());
    }

}
