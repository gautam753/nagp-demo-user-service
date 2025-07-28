package com.demo.nagp.userservice.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ApiKeyFilter extends OncePerRequestFilter {

	@Value("${x-api-key.value}")
	private String apiKey;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		String requestKey = request.getHeader("X-API-KEY");
		String requestpath = request.getRequestURI();
		if (!(requestpath.contains("swagger-ui") 
				|| requestpath.contains("swagger-config") 
				|| requestpath.contains("api-docs")
				|| requestpath.contains("/actuator/health")
			) && (requestKey == null || !requestKey.equals(apiKey))) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write("Invalid API Key");
			return;
		}
		chain.doFilter(request, response);
	}
}