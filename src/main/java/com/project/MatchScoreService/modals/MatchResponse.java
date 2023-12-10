package com.project.MatchScoreService.modals;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MatchResponse {
	private String year;
	private Long numberOfMatches;
	private String status;
}
