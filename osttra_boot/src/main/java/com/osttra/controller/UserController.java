package com.osttra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.osttra.service.UserService;
import com.osttra.to.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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
		
		System.out.println("inside register()..."+user);
		
		userService.register(user);
		
		return "index";
	}
	
//	@PostMapping("/login")
//	public ModelAndView login(String username, String password) {
//		
//		System.out.println("inside login mapping() "+username+", "+password);
//		
//		User user = userService.login(username, password);
//		
//		ModelAndView modelAndView = null;
//		
//		if( user != null ) {
//			
//			modelAndView = new ModelAndView("welcome_page");
//			modelAndView.addObject("user", user);
//		}
//		else {
//			modelAndView = new ModelAndView("index");
//			modelAndView.addObject("errorMessage", "Wrong Credentials, please try again!!");
//		}
//		
//		return modelAndView;
//	}
	
	@PostMapping("/login")
	public ModelAndView login(String username, String password, HttpServletRequest request) {
		
		System.out.println("inside login mapping() "+username+", "+password);
		
		User user = userService.login(username, password);
		
		ModelAndView modelAndView = null;
		
		if( user != null ) {
			
			modelAndView = new ModelAndView("welcome_page");
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//modelAndView.addObject("user", user);
		}
		else {
			modelAndView = new ModelAndView("index");
			modelAndView.addObject("errorMessage", "Wrong Credentials, please try again!!");
		}
		
		return modelAndView;
	}
	
	@GetMapping("/delete/{username}")
	public String delete(@PathVariable String username) {
		
		System.out.println(username);
		
		userService.delete(username);
		
		return "index";
	}
	
	@GetMapping("/updatePage/{username}")
	public ModelAndView updatePage(@PathVariable String username, HttpServletRequest request) {
		System.out.println("ZUserame is "+username);
		
		ModelAndView modelAndView = null;
		
		HttpSession session = request.getSession(false);
		
		//User user = userService.getUser(username);
		
		if( session != null ) {
			modelAndView = new ModelAndView("update_user");
		}
		else {
			modelAndView = new ModelAndView("index");
		}
		
		//modelAndView.addObject("user", user);
		
		return modelAndView;
			
	}
	
	@PutMapping(value = "/update")
	public void update(User user, HttpServletRequest request) {
		
		System.out.println(user);
		
		userService.update(user);
		
		HttpSession session = request.getSession(false);
		
		User oldUser = ( User )session.getAttribute("user");
		
		String password = oldUser.getPassword();
		String role = oldUser.getRole();
		
		user.setPassword(password);   user.setRole(role);
		
		session.setAttribute("user", user);
		
		ModelAndView modelAndView = new ModelAndView("welcome_page");
		modelAndView.addObject("updateSuccessMsg", "Your Profile is updated successfully");
	}
}
