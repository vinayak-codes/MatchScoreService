package com.project.MatchScoreService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.MatchScoreService.repo.UserRepository;

@SpringBootApplication
public class MatchScoreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatchScoreServiceApplication.class, args);
		System.out.println("Application running");
		UserRepository repository = new UserRepository();
		System.out.println(repository.getUserbyName("vinayak").toString());
	}
}
