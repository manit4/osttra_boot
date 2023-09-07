package com.osttra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.osttra.helper.JWTHelper;
import com.osttra.service.CustomUserDetailsService;
import com.osttra.to.JWTRequest;

@RestController
public class JWTTokenController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	JWTHelper jwtHelper;
	
	@PostMapping("/token")
	public String generateToken(@RequestBody JWTRequest jwtRequest) {
		
		System.out.println("JWT request is "+jwtRequest);
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		}
		catch (Exception e) {
			System.out.println("inside catch of generateToken");
			e.printStackTrace();
		}
		
		UserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String jwtToken = jwtHelper.generateToken(userDetails);
		System.out.println("JWT Token is "+jwtToken);
		
		return jwtToken;
		
	}

}
