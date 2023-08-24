package com.osttra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.osttra.repository.UserRepository;
import com.osttra.to.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserService() {
		System.out.println("inside Userservice constr...");
	}
	
	public void register(User user) {
		
		userRepository.add(user);
	}

}
