package com.osttra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.osttra.service.IContactService;
import com.osttra.to.Contact;

@RestController
public class ContactController {
	
	@Autowired
	IContactService contactService;
	
	@GetMapping("/contact/user/{username}")
	public List<Contact> getContact(@PathVariable String username) {
		
		return contactService.getContact(username);
	}

}
