package com.project.MatchScoreService.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class MatchData {
	@SerializedName("competition")
	@Expose
	public String competition;
	@SerializedName("year")
	@Expose
	public Integer year;
	@SerializedName("round")
	@Expose
	public String round;
	@SerializedName("team1")
	@Expose
	public String team1;
	@SerializedName("team2")
	@Expose
	public String team2;
	@SerializedName("team1goals")
	@Expose
	public String team1goals;
	@SerializedName("team2goals")
	@Expose
	public String team2goals;
}
