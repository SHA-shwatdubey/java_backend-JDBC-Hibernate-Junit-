package com.example.service.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class RechargeProducerDTO implements Serializable{

	private String mobileNumber;
	private String operator;
	
	private double amount;
	
}
