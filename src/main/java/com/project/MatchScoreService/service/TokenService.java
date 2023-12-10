package com.project.MatchScoreService.service;

import javax.servlet.http.HttpServletRequest;

import com.project.MatchScoreService.modals.JWTDetailsResponse;

public interface TokenService {
	JWTDetailsResponse getTokenDetailsResponse(HttpServletRequest req);
}
