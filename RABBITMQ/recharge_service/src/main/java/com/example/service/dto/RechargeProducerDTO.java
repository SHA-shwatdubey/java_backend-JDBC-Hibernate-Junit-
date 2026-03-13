package com.example.service.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class RechargeProducerDTO implements Serializable{

	private String mobileNumber;
	private double amount;
	private String operator;
	
	public RechargeProducerDTO() {}
	
}
