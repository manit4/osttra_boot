package com.osttra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public User login(String username, String password) {

		return userRepository.getUser(username, password);
	}
	
	public void delete(String username) {
		
		userRepository.delete(username);
	}
	
	public User getUser(String username) {
		
		User user = userRepository.getUser(username);
		
		return user;
	}
	
	public void update(User user) {
		
		userRepository.update(user);
	}
	
	public List<User> getUsers() {
		
		return userRepository.getUsers();
	}
	
	
}
