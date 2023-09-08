package com.osttra.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.osttra.to.User;

@Service
public class UserServiceImpl implements IUserService {

	List<User> users = new ArrayList<>();

	public UserServiceImpl() {

		User user1 = new User("kes@123", "1234", "Keshav Tyagi", null);
		User user2 = new User("nav@123", "2345", "Navneet Singh", null);
		User user3 = new User("gau@123", "3456", "Gaurav Jaiswal", null);

		users.add(user1);
		users.add(user2);
		users.add(user3);
		System.out.println("size of user list is " + users.size());

	}

	@Override
	public User getUser(String username) {

		for (User user : users) {

			if (user.getUsername().equals(username)) {

				return user;
			}
		}

		return null;
	}

}
