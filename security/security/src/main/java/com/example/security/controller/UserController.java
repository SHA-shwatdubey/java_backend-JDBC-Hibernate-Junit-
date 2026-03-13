package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class UserController {
	
	@GetMapping("/practises")
	public String getDetails() {
		return "Details";
	}
	
	@GetMapping("/admin")
	public String deleteUser() {
		return "Delete";
	}
	
}
