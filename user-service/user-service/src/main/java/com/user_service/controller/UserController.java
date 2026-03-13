package com.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user_service.entity.UserInformation;
import com.user_service.repo.PaymentFeignClient;
import com.user_service.service.UserService;

@RestController
public class UserController {

	private UserService service;
	
	@Autowired
	private PaymentFeignClient payment;

	public UserController(UserService service) {
		this.service = service;
	}

	@PostMapping("/create")
	public String create(@RequestBody UserInformation info) {
		return service.createUser(info);
	}
	

	@GetMapping("/{email}")
	public UserInformation findById(@PathVariable String email) {
		return service.findUser(email);
	}
	
	@GetMapping("/hi")
	public String getHi() {
		System.out.println("8001 hii");
		return "hi";
	}
	
	@GetMapping("/pay")
	public List<String> getPayment(){
		return payment.paymentOption();
	}
	
}
