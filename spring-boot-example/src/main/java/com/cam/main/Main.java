package com.cam.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
//	@GetMapping("/")
//	public GreetResponse greet() {
//		return new GreetResponse(
//				"Hello Cameron",
//				new ArrayList<String>(List.of("c++", "python", "javascript")),
//				new Person("Cameron", 30, 'm')
//		);
//	}
	
//	record Person(String name, int age, char sex) {}
//	record GreetResponse(String greet, List<String> favProgLang, Person person) {}
	
}
