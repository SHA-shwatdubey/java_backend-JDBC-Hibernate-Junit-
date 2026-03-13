package com.example.securitypractise.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.securitypractise.dto.AccountRequestDTO;
import com.example.securitypractise.dto.AccountResponseDTO;
import com.example.securitypractise.entity.Account;
import com.example.securitypractise.service.AccountService;

@RestController
public class AccountController {

	private  AccountService service;
	
	public AccountController(AccountService service) {
		super();
		this.service = service;
	}

	@PostMapping("/public/create")
	public AccountResponseDTO create(@RequestBody AccountRequestDTO dto) {
		System.out.println(dto.getEmail());
		return service.createAccount(dto);
	}
	
	@GetMapping("/find-id/{id}")
	public AccountResponseDTO getById(@PathVariable long id) {
		return service.getById(id);
	}
	
	@GetMapping("/admin/findAll")
	public List<AccountResponseDTO> getAllUsersAndAdmins(){
		return service.getAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public AccountResponseDTO deleteById(@PathVariable Long id) {
		return service.deleteById(id);
	}
	
	@GetMapping("/public/profile")
	public String profile(Authentication authentication) {
		return authentication.getName() + " " + authentication.getAuthorities();
	}
	
	
}
