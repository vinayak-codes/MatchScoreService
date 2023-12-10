package com.project.MatchScoreService.modals;

import lombok.Data;

@Data
public class AuthenticationRequest {
	private String username;
	private String password;
}
