package com.osttra.service;

import java.util.List;

import com.osttra.to.Contact;

public interface IContactService {
	
	public List<Contact> getContact(String username);

}
