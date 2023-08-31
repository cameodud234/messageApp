package com.cam;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;


import com.cam.entity.User;
 
@SpringBootApplication

//public class App {
//     
//    public static void main(String[] args) {
//        SpringApplication.run(App.class, args);
//    }
// 
//}

public class App implements CommandLineRunner {
 
    @Autowired
    private JdbcTemplate jdbcTemplate;
     
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
 
    @Override
    public void run(String... args) throws Exception {
        String sql = "SELECT * FROM Users WHERE Users.email = ?";
        String emailQuery = "camerondudley2@gmail.com";
        
        List<User> userList = jdbcTemplate.query(sql, (rs, rowNum) -> {
        	String firstName = rs.getString("first_name");
        	String lastName = rs.getString("last_name");
        	String userName = rs.getString("user_name");
        	String email = rs.getString("email");
        	String password = rs.getString("password");
        	Date dateOfBirth = rs.getDate("date_of_birth");
        	String description = rs.getString("description");
        	return new User(firstName, lastName, userName, email, password, dateOfBirth, description);
        }, emailQuery);
        
        System.out.println(userList.get(0));
        
    }
 
}