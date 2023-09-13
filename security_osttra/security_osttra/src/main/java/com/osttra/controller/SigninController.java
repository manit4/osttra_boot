package com.osttra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.osttra.entity.User;
import com.osttra.repository.UserRepository;

@Controller
public class SigninController {
	
	@Autowired
	UserRepository userRepository;
	
//	@Autowired
//	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/signin")
	public String signin() {
		
		return "login";
	}
	
	@GetMapping("/registration_page")
	public String registrationPage() {
		
		return "registration";
	}
	
//	@PostMapping("/register")
//	public String register(User user) {
//		
//		System.out.println(user);
//		
//		String password = user.getPassword();
//		String encodedPassword = this.bCryptPasswordEncoder.encode(password);
//		System.out.println(encodedPassword);
//		user.setPassword(encodedPassword);
//		
//		
//		userRepository.save(user);
//		
//		return "welcome";
//	}

	
}
