package com.example.GestioneDispositivi.model;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class WebSecurityConfigurerAdapter {

	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		// TODO Auto-generated method stub

	}

	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub

	}

	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
