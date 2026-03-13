package com.example.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.dto.RechargeProducerDTO;
import com.example.service.serv.RechargeService;

@RestController
public class RechargeController {

	@Autowired
	private RechargeService rechargeService;
	
	@PostMapping("/recharge")
	public String doRecharge(@RequestBody RechargeProducerDTO dto) {
		return rechargeService.sendRechargeRequest(dto);
	}
	
}
