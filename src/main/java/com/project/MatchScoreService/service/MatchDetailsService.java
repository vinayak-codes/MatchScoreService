package com.project.MatchScoreService.service;

import com.project.MatchScoreService.modals.MatchResponse;

public interface MatchDetailsService {
	
	MatchResponse getDrawMatches(String year);
}
