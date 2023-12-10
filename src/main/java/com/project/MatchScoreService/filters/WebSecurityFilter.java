package com.project.MatchScoreService.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.project.MatchScoreService.service.UserService;
import com.project.MatchScoreService.utility.JWTUtility;

@Component
public class WebSecurityFilter extends OncePerRequestFilter{
	
	@Autowired
	private JWTUtility jwtUtility;
	
	@Autowired
	private UserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//Read the token from the auth header
		String header = request.getHeader("Authorization");
		if(header != null) {
			String token = header.trim().substring(6).trim();
			System.out.println("Token from header : " + token);
			String username = jwtUtility.getUsernameFromToken(token);
			if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = userService.loadUserByUsername(username);
				boolean isAuthenticated = jwtUtility.validateToken(token, userDetails);
				
				if(isAuthenticated) {
					
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
							username,
							userDetails.getPassword(),
							userDetails.getAuthorities());
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authToken);
					
				}
			}
		}
		filterChain.doFilter(request, response);
	}

}
