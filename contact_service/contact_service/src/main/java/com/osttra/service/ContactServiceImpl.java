package com.osttra.service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

import org.springframework.stereotype.Service;

import com.osttra.to.Contact;

@Service
public class ContactServiceImpl implements IContactService {

	List<Contact> contacts = new ArrayList<>();

	public ContactServiceImpl() {

		Contact contact1 = new Contact("c_001", "Noida", "U.P", "kes@123");
		Contact contact2 = new Contact("c_002", "Gaziabad", "U.P", "nav@123");
		Contact contact3 = new Contact("c_003", "Bangalore", "Karnataka", "nav@123");
		Contact contact4 = new Contact("c_004", "Delhi", "Capital", "gau@123");

		contacts.add(contact1);
		contacts.add(contact2);
		contacts.add(contact3);
		contacts.add(contact4);

		System.out.println("Contacts size is " + contacts.size());
	}

	public List<Contact> getContact(String username) {
		
		List<Contact> contacts = new ArrayList<>();

		for (Contact contact : this.contacts) {

			if (contact.getUsername().equals(username)) {
				System.out.println("isjdei");
				contacts.add(contact);
			}
		}
		return contacts;
	}

}
