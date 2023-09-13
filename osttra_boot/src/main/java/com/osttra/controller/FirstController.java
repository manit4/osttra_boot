package com.osttra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osttra.to.Product;
import com.osttra.to.User;

@RestController
@CrossOrigin
public class FirstController {
	
	@GetMapping("/getMsg")
	public String getMessage() {
		
		return "Hi there, I am doing good and I am updating you and updating again...";
	}
	
//	@GetMapping("/getUser")
//	public User getUser() {
//		System.out.println("inside getUser() of FirstController...");
//		
//		User user = new User("abcd", "123", "Manit");
//		
//		System.out.println("User is "+user);
//		
//		return user;
//	}
	
//	@GetMapping("/getAllUsers")
//	public List<User> getUsers() {
//		
//		User user1 = new User("abcd", "123", "Manit");
//		User user2 = new User("bcde", "234", "Trijal");
//		User user3 = new User("cdef", "345", "Naman");
//		
//		List<User> users = new ArrayList<>();
//		
//		users.add(user1);   users.add(user2);   users.add(user3);
//		
//		return users;
//	}
	
	@GetMapping("/allProducts")
	public List<Product> getAllProducts() {
		
		System.out.println("insdie hi");
		
		List<Product> products = new ArrayList<>();
		
		Product product1 = new Product("p_001", "Levis Jeans", "1000");
		Product product2 = new Product("p_002", "Levis T_Shirt", "600");
		Product product3 = new Product("p_002", "Levis T_Shirt", "600");
		
		products.add(product1);    products.add(product2);   products.add(product3);
		
		
		return products;
		
	}

}
