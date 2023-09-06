package com.osttra.service;

import java.util.List;

import com.osttra.to.User;

public interface IUserService {
	
	public void register(User user);

	public User login(String username, String password);
	
	public void delete(String username);
	
	public User getUser(String username);
	
	public void update(User user);
	
	public List<User> getUsers();

}
