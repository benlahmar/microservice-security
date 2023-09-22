package com.example.demo.sec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.sec.service.MyUserService;

@Configuration

public class MyConfig {

	//2aspect 1.auth  2.authorization
	@Autowired
	MyUserService service;
	/**
	 * 
	 * @param auth
	 * @return
	 * @throws Exception
	 * pour l'authentification
	 */
	@Bean
	public AuthenticationManager authenticationManager(
			AuthenticationConfiguration auth) throws Exception
	{
		return auth.getAuthenticationManager();
	}
	

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		
	 		http
	 		.csrf(d->d.disable())
	 			.authorizeHttpRequests((authorizeHttpRequests) ->
	 				authorizeHttpRequests
	 					.requestMatchers("/auth/**").permitAll()
	 					.requestMatchers("/users/**").hasAuthority("admin")
	 					.requestMatchers("/test").hasAuthority("user") 
	 					.anyRequest()
	 					.authenticated()
	 			)
	 			.formLogin(  f->f.permitAll() );
	 		return http.build();
	 	}

	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
		

		
	}
	

