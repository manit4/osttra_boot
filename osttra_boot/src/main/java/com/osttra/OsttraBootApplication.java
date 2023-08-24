package com.osttra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.osttra.to.User;

@SpringBootApplication
public class OsttraBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsttraBootApplication.class, args);
		System.out.println();
	}
	
	@Bean
	public User getUser() {
		
		System.out.println("inside getUser bean...");
		
		return new User();
	}

}
