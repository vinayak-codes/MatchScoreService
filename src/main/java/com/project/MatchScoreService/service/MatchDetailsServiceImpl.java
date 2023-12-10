package com.project.MatchScoreService.service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.MatchScoreService.modals.FootballMatchesResponse;
import com.project.MatchScoreService.modals.MatchData;
import com.project.MatchScoreService.modals.MatchResponse;

@Service
public class MatchDetailsServiceImpl implements MatchDetailsService{
	
	private static final String URL = "https://jsonmock.hackerrank.com/api/football_matches?year=";
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	

	@Override
	public MatchResponse getDrawMatches(String year) {
		try {
			String url = getApiUrl(year);
			FootballMatchesResponse response = getMatchResponseFromAPI(url);
			
			long matchCount = getMatchCountFromResponse(response);
			
			Thread.sleep(getRandomTime()); //Delaying the response
			
			return MatchResponse.builder()
					.year(year)
					.numberOfMatches(matchCount)
					.status("DRAW")
					.build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private long getRandomTime() {
		int low = 3;
		int high = 6;
		return new Random().nextInt(high - low + 1) + low * 1000; //Converting to millisec
	}


	private long getMatchCountFromResponse(FootballMatchesResponse response) {
		return response.getData()
				.stream()
				.filter(m -> m.getTeam2goals().equals(m.getTeam1goals()))
				.count();
	}


	private String getApiUrl(String year) {
		StringBuilder sb  = new StringBuilder(URL);
		sb.append(year);
		sb.append("&page=1");
		return sb.toString();
	}


	public FootballMatchesResponse getMatchResponseFromAPI(String url) throws Exception{
		ExecutorService executorService = Executors.newFixedThreadPool(1);
        Callable<FootballMatchesResponse> callableTask = () -> {
        	FootballMatchesResponse matchResponse = restTemplate.getForObject(url, FootballMatchesResponse.class);
			return matchResponse;
        };
        try {
        	Future<FootballMatchesResponse> future = executorService.submit(callableTask);
        	FootballMatchesResponse matchResponse = future.get();
        	return matchResponse;
        }catch (Exception e) {
			throw new Exception("Unable to get response from API");
		}finally {
			executorService.shutdown();
		}
        
	}

}
