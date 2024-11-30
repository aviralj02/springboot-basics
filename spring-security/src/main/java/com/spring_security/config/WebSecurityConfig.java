package com.spring_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.spring_security.utils.JwtAuthenticationEntryPoint;
import com.spring_security.utils.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
		// We don't need CSRF for this example
		httpSecurity.csrf(csrf -> csrf.disable())
		// dont authenticate this particular request
		.authorizeHttpRequests(auth -> auth.requestMatchers("/authenticate", "/greet").permitAll()
				// all other requests need to be authenticated
				.anyRequest().authenticated())
		// make sure we use stateless session; session won't be
		// used to store user's state.
		.exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthenticationEntryPoint))
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

		// Add a filter to validate the tokens with every request
		.addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class);
		
		return httpSecurity.build();
	}
}
