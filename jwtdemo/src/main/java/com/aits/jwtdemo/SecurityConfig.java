package com.aits.jwtdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
 
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
 
 
    public SecurityConfig(JwtUtil jwtUtil,UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
		this.userDetailsService = userDetailsService;
        
    }
 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	 http
         .csrf(csrf -> csrf.disable()) // 🔹 Explicitly disable CSRF if not using forms
         .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // 🔹 Stateless session
         .authorizeHttpRequests(auth -> auth
             .requestMatchers("/auth/login").permitAll() // Allow login without authentication
             .anyRequest().authenticated() // All other endpoints require authentication
         )
         .addFilterBefore(new JwtAuthenticationFilter(jwtUtil,userDetailsService), UsernamePasswordAuthenticationFilter.class);
 
     return http.build();
    }
 
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
 
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Encrypt passwords
    }
}
 
