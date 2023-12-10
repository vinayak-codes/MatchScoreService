package com.project.MatchScoreService.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.MatchScoreService.modals.User;

/* 
 * Not using database to store and retrieve user details for simplicity 
 * Creating some dummy users instead and validating for that user only
 */


@Component
public class UserRepository {
	
	private static List<User> users = new ArrayList<>();
	
	static {
		init();
	}
	
	public static void init() {
		users.add(new User("vinayak","pass@123", User.Role.ADMIN));
		users.add(new User("Rohan", "pass@456", User.Role.USER));
	}
	
	// TODO : implement database layer for storing users
	
	public User getUserbyName(String name){
			return users.stream()
				.filter(u -> u.getUserName().equalsIgnoreCase(name))
				.collect(Collectors.toList()).get(0);
	}
}
