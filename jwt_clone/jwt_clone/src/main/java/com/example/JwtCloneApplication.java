package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class JwtCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtCloneApplication.class, args);
	}

}