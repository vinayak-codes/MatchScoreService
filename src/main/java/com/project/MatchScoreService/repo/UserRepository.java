package com.project.MatchScoreService.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.MatchScoreService.modals.User;

@Component
public class UserRepository {
	
	private static List<User> users = new ArrayList<>();
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	/* 
	 * Not using database to store and retrieve user details for simplicity 
	 * Creating some dummy users instead and validating for that user only
	 */

	
	public void generateUsers(){
		users.add(new User("vinayak",
				 encoder.encode("Pass@123"),
				 User.Role.ADMIN));
		users.add(new User("Rohan",
				encoder.encode("Pass@456"),
				User.Role.USER));
	}
	
	// TODO : implement database layer for storing users
	
	public User getUserbyName(String name){
			return users.stream()
				.filter(u -> u.getUserName().equalsIgnoreCase(name))
				.collect(Collectors.toList()).get(0);
	}
}
