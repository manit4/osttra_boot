package com.osttra.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import com.osttra.to.User;
import com.osttra.utils.DBUtils;

@Repository
public class UserRepository {
	
	public UserRepository() {
		
		System.out.println("inside UserREpository constr");
	}
	
	public void add(User user) {
		
		try {
			
			Connection connection = DBUtils.getConnection();
			
			PreparedStatement statement = connection.prepareStatement("insert into user values(?, ?, ?, ?)");
			
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getCompleteName());
			statement.setString(4, user.getEmail());
			statement.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("inside catch of add() of UserRepository...");
			e.printStackTrace();
		}
	}

}
