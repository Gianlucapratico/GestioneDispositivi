package com.example.GestioneDispositivi.model;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private final AuthenticationManager authenticationManager;
	private final String secret;
	private final int expirationMs;

	public JwtAuthenticationFilter(AuthenticationManager authenticationManager, String secret, int expirationMs) {
		this.authenticationManager = authenticationManager;
		this.secret = secret;
		this.expirationMs = expirationMs;
		setFilterProcessesUrl("/api/login");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			Utente credenziali = new ObjectMapper().readValue(request.getInputStream(), Utente.class);
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(credenziali.getUsername(), credenziali.getPassword()));
		} catch (IOException | java.io.IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String token = Jwts.builder().setSubject(((Utente) authResult.getPrincipal()).getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + expirationMs))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
		response.addHeader("Authorization", "Bearer " + token);
	}
}
