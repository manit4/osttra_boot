package com.trijal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.osttra.service.UserService;
import com.osttra.to.User;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	public UserController() {
		System.out.println("inside UserController constr...");
	}
	

//	@PostMapping("/register")
//	public String register(String username, String password, String completeName, String email) {
//		
//		System.out.println("inside register()..."+username+", "+password+", "+completeName+", "+email);
//		
//		return "index";
//	}
	
	@PostMapping("/register")
	public String register(User user) {
		
		System.out.println("inside register()..."+user.getUsername()+", "+user.getPassword()+", "+user.getCompleteName()+", "+user.getEmail());
		
		userService.register(user);
		
		return "index";
	}
}
