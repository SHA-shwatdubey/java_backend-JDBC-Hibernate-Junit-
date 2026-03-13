package com.example.securitypractise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
	    return http
	    		.cors(cors->{})
	            .csrf(csrf -> csrf.disable())
	            .authorizeHttpRequests(auth -> auth
//	                    .requestMatchers("/create/**").permitAll()
	                    .requestMatchers("/public/**").permitAll()
	                    .requestMatchers("/actuator/**").permitAll()
	                    .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
	                    .anyRequest().authenticated()
	            )
	            .httpBasic(Customizer.withDefaults())
	            .build();
	}
	
}
