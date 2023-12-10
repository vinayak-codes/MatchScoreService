package com.project.MatchScoreService.modals;

import lombok.Data;

@Data
public class MatchResponse {
	private String year;
	private Integer numberOfMatches;
	private String status;
}
