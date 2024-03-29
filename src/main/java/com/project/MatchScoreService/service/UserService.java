package com.project.MatchScoreService.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.MatchScoreService.modals.User;
import com.project.MatchScoreService.repo.UserRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		/* 
		 * Not using database to store and retrieve user details for simplicity 
		 * Creating a dummy user instead and validating for that user only
		 */
		userRepository.generateUsers();
		User user = userRepository.getUserbyName(username);
		return new org.springframework.security.core.userdetails.User(
				user.getUserName(),
				user.getPassword(),
				Arrays.asList(new SimpleGrantedAuthority(user.getRole().name())));
	}

}
