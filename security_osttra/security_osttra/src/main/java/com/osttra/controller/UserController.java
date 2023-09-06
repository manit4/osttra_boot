package com.osttra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(value = "/user")
public class UserController {
	
	@GetMapping("/home")
	public String home() {
		
		return "This is Home Page";
	}
	
	
	
	@GetMapping("/registring_page")
	public String registrationPage() {
		
		return "This isRegistration Page";
	}
	
	@GetMapping("/welcomePage")
	public String welcomePage() {
		
		return "This is Welcome Page";
	}
		
}
