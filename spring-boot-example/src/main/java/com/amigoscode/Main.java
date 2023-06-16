package com.amigoscode;

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
	
	@GetMapping("/")
	public GreetResponse greet() {
		return new GreetResponse("Hello");
	}
	
//	record GreetResponse(String greet) {}
	
	public class GreetResponse {
		
		private String greet;
		
		public GreetResponse(String greet) {
			super();
			this.greet = greet;
		}

//		public String getGreet() {
//			return greet;
//		}

		public void setGreet(String greet) {
			this.greet = greet;
		}

		@Override
		public String toString() {
			return "GreetResponse [greet=" + greet + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(greet);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			GreetResponse other = (GreetResponse) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return Objects.equals(greet, other.greet);
		}

		private Main getEnclosingInstance() {
			return Main.this;
		}
		
		
		
	}
	
}
