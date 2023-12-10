package com.project.MatchScoreService.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.MatchScoreService.modals.JWTDetailsResponse;
import com.project.MatchScoreService.utility.JWTUtility;

import io.jsonwebtoken.Claims;

@Service
public class TokenServiceImpl implements TokenService{
	
	
	@Autowired
	private JWTUtility utility;

	@Override
	public JWTDetailsResponse getTokenDetailsResponse(HttpServletRequest request) {
		JWTDetailsResponse response = new JWTDetailsResponse();
		String header = request.getHeader("Authorization");
		if(header != null) {
			String token = header.trim().substring(6).trim();
			Claims claims = utility.getAllClaims(token);
			response.setSubject(claims.getSubject());
			response.setIssuer(claims.getIssuer());
			response.setIssuedAt(claims.getIssuedAt());
			response.setExpirationTime(claims.getExpiration());
		}
		return response;
	}

}
