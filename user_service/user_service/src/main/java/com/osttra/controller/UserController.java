package com.osttra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.osttra.service.UserServiceImpl;
import com.osttra.to.Contact;
import com.osttra.to.User;

@RestController
public class UserController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/getUser/{username}")
	public User getUser(@PathVariable String username) {
		
		List<Contact> contacts = restTemplate.getForObject("http://localhost:8081/contact/user/"+username, List.class);
		
		User user = userServiceImpl.getUser(username);
		user.setContacts(contacts);
		
		return user;
	}

}
