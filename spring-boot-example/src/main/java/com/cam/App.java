package com.cam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cam.entity.User;

@SpringBootApplication

public class App {
	
	private final static Logger log = LogManager.getLogger(App.class);

    public static void main(String[] args) {
    	try {
    		
    		SpringApplication.run(App.class, args);
			
		} catch (Exception e) {
			log.info(e.getMessage(), e.getCause());
		}
    }

}