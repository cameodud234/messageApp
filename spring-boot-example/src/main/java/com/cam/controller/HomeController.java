package com.cam.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@CrossOrigin
	@RequestMapping("/")
	String home() {
		return "Connection To backend successful";
	}
	
}
