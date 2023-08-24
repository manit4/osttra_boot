package com.osttra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String indexPage() {
		
		System.out.println("inside index page...");
		
		return "index";
	}
	
	@GetMapping("/registrationPage")
	public String registrationPage() {
		
		System.out.println("inside registrationPage()...");
		
		return "registration_page";
	}

}
