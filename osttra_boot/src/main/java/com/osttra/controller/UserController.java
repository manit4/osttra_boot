package com.osttra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

		System.out.println("inside register()..." + user);

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

		System.out.println("inside login mapping() " + username + ", " + password);

		User user = userService.login(username, password);

		ModelAndView modelAndView = null;

		if (user != null) {

			modelAndView = new ModelAndView("welcome_page");

			HttpSession session = request.getSession();
			System.out.println("session is while login "+session);
			session.setAttribute("user", user);

			if (user.getRole().equals("Admin")) {

				List<User> users = userService.getUsers();
				// session.setAttribute("users", users);
				// request.setAttribute("users", users);
				modelAndView.addObject("users", users);
			}

			// modelAndView.addObject("user", user);
		} else {
			modelAndView = new ModelAndView("index");
			modelAndView.addObject("errorMessage", "Wrong Credentials, please try again!!");
		}

		return modelAndView;
	}

	@GetMapping("/delete/{username}")
	public ModelAndView delete(@PathVariable String username, HttpServletRequest request) {

		System.out.println(username);

		ModelAndView modelAndView = null;

		HttpSession session = request.getSession(false);

		if (session != null) {
			System.out.println("inside if of delete");
			userService.delete(username);

			if (((User) session.getAttribute("user")).getRole().equals("Admin")) {

				modelAndView = new ModelAndView("welcome_page");
				List<User> users = userService.getUsers();
				modelAndView.addObject("users", users);
			} else {
				modelAndView = new ModelAndView("index");
				modelAndView.addObject("deleteSucessMsg", "Your Account has been deleted successfully..");
			}
		} else {
			System.out.println("insdie else of delete...");
			modelAndView = new ModelAndView("index");
			modelAndView.addObject("errorMessage", "You are not authenticated, please login first!!");
		}

		return modelAndView;
	}

	@GetMapping("/updatePage/{username}")
	public ModelAndView updatePage(@PathVariable String username, HttpServletRequest request) {
		System.out.println("ZUserame is " + username);

		ModelAndView modelAndView = null;

		HttpSession session = request.getSession(false);
		System.out.println("Session is while upadting page "+session);
		
		User deletingUser = userService.getUser(username);

		// User user = userService.getUser(username);

		if (session != null) {
			System.out.println("Is session new "+session.isNew());
			modelAndView = new ModelAndView("update_user");
			modelAndView.addObject("deletingUser", deletingUser);
		} else {
			modelAndView = new ModelAndView("index");
		}

		// modelAndView.addObject("user", user);

		return modelAndView;

	}

//	@GetMapping("/updatePage/{username}")
//	public ModelAndView updatePage(@PathVariable String username) {
//		System.out.println("ZUserame is "+username);
//		
//		ModelAndView modelAndView = new ModelAndView("update_user");
//		
//		
//		
//		User user = userService.getUser(username);
//		
//		modelAndView.addObject("user", user);
//		
//		return modelAndView;
//			
//	}

	@PutMapping(value = "/update")
	public void update(User user, HttpServletRequest request) {

		System.out.println(user);

		userService.update(user);

		HttpSession session = request.getSession(false);

		User oldUser = (User) session.getAttribute("user");

		String password = oldUser.getPassword();
		String role = oldUser.getRole();

		user.setPassword(password);
		user.setRole(role);

		session.setAttribute("user", user);

		ModelAndView modelAndView = new ModelAndView("welcome_page");
		modelAndView.addObject("updateSuccessMsg", "Your Profile is updated successfully");
	}

	@GetMapping("/welcome")
	public ModelAndView welcomeHome(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		ModelAndView modelAndView = null;

		if (session != null) {

			if (((User) session.getAttribute("user")).getRole().equals("Admin")) {

				modelAndView = new ModelAndView("welcome_page");
				List<User> users = userService.getUsers();
				modelAndView.addObject("users", users);
			} else {

				modelAndView = new ModelAndView("welcome_page");
			}

		} else {

			modelAndView = new ModelAndView("index");
			modelAndView.addObject("errorMessage", "You are not authenticated, please login first!!");
		}
		return modelAndView;
	}

	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {

		ModelAndView modelAndView =  new ModelAndView("index");

		HttpSession session = request.getSession(false);
		System.out.println("Session is while logout "+session);

		if (session != null) {

			session.invalidate();
			
			modelAndView.addObject("logoutMessage", "Logged-out successfully..");
		} else {

			modelAndView.addObject("errorMessage", "You were never logged-in, please login first to logout!!");
		}

		return modelAndView;
	}

}
