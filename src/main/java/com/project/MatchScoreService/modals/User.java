package com.project.MatchScoreService.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class User {
	private String userName;
	private String password;
	private Role role;
	
	
	public enum Role{
		ADMIN, USER;
	}
}
