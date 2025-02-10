//package com.ashwin.poc.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeHttpRequests((requests) -> requests
//				.chainRequestMatchers("/getById","").authenticated());
//				
//		return http.build();
//	}
//
//	@Bean
//	UserDetailsService userDetailsService() {
//
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//		String pass = encoder.encode("rawPassword");
//
//		UserDetails user = User.withUsername("user").password(pass).roles("USER").build();
//		return new InMemoryUserDetailsManager(user);
//	}
//
//}
