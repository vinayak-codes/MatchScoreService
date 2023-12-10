package com.project.MatchScoreService.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.MatchScoreService.modals.JWTDetailsResponse;

@RestController
public class ScoreController {
	
	
	@GetMapping("/message")
	public String getMessage() {
		return "Welcome to the app";
	}
	
	@GetMapping("/getDetails")
	public ResponseEntity<JWTDetailsResponse> getTokenDetails(){
		return new ResponseEntity<>( new JWTDetailsResponse(), HttpStatus.OK);
	}
	
	@GetMapping("/getDrawMatches")
	public ResponseEntity<String> getNumberOfDrawMathes(@RequestParam String year){
		return null;
	}
}
