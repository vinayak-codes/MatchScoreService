package com.project.MatchScoreService.modals;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class FootballMatchesResponse {

	@SerializedName("page")
	@Expose
	public Integer page;
	@SerializedName("per_page")
	@Expose
	public Integer perPage;
	@SerializedName("total")
	@Expose
	public Integer total;
	@SerializedName("total_pages")
	@Expose
	public Integer totalPages;
	@SerializedName("data")
	@Expose
	public List<MatchData> data;

}