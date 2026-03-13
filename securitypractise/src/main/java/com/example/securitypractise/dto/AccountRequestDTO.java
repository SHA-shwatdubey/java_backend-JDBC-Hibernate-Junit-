package com.example.securitypractise.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AccountRequestDTO {

	private String fullName;
	private String username;
	private String email;
	private String password;
	private String phone;
	private String role;
	private LocalDateTime createdAt = LocalDateTime.now();
	
}
