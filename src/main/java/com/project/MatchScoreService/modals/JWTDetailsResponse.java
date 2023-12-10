package com.project.MatchScoreService.modals;

import java.util.Date;

import lombok.Data;

@Data
public class JWTDetailsResponse {
	private String subject;
	private String issuer;
	private Date issuedAt;
	private Date expirationTime;
}
