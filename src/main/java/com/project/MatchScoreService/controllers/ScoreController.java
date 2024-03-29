package com.project.MatchScoreService.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.MatchScoreService.modals.AuthenticationRequest;
import com.project.MatchScoreService.modals.JWTDetailsResponse;
import com.project.MatchScoreService.modals.MatchResponse;
import com.project.MatchScoreService.modals.TokenResponse;
import com.project.MatchScoreService.repo.UserRepository;
import com.project.MatchScoreService.service.MatchDetailsService;
import com.project.MatchScoreService.service.TokenService;
import com.project.MatchScoreService.service.UserService;
import com.project.MatchScoreService.utility.JWTUtility;

@RestController
public class ScoreController {
	
	@Autowired
	private JWTUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private MatchDetailsService matchService;
	
	

	@GetMapping("/test")
	public String getMessage() {
		repository.generateUsers();
		return repository.getUserbyName("Vinayak").toString();
	}
	
	@PostMapping("/login")
	public ResponseEntity<TokenResponse> getToken(@RequestBody AuthenticationRequest request) throws Exception{
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				request.getUsername(),
				request.getPassword()));
		
		final UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
		final String token = jwtUtility.generateToken(userDetails); 
		return new ResponseEntity<TokenResponse>(new TokenResponse(token, "Token generated successfully"), HttpStatus.OK);
	}
	
	@GetMapping("/getTokenDetails")
	public ResponseEntity<JWTDetailsResponse> getTokenDetails(HttpServletRequest request){
		JWTDetailsResponse response = tokenService.getTokenDetailsResponse(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getDrawMatches")
	public ResponseEntity<MatchResponse> getNumberOfDrawMathes(@RequestParam String year){
		MatchResponse response = matchService.getDrawMatches(year);
		return new ResponseEntity<MatchResponse>(response, HttpStatus.OK);
	}
}
