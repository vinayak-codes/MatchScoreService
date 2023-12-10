package com.project.MatchScoreService.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.MatchScoreService.modals.AuthenticationRequest;
import com.project.MatchScoreService.modals.JWTDetailsResponse;
import com.project.MatchScoreService.modals.TokenResponse;

@RestController
public class ScoreController {
	
	
	@GetMapping("/message")
	public String getMessage() {
		return "Welcome to the app";
	}
	
	@GetMapping("/getToken")
	public ResponseEntity<TokenResponse> getToken(@RequestBody AuthenticationRequest request){
		return null;
	}
	
	
	
	@GetMapping("/getTokenDetails")
	public ResponseEntity<JWTDetailsResponse> getTokenDetails(){
		return new ResponseEntity<>( new JWTDetailsResponse(), HttpStatus.OK);
	}
	
	@GetMapping("/getDrawMatches")
	public ResponseEntity<String> getNumberOfDrawMathes(@RequestParam String year){
		return null;
	}
}
