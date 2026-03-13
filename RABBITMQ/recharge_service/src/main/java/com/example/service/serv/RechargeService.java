package com.example.service.serv;

import java.util.HashSet;
import java.util.Set;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.service.config.RabbitConfig;
import com.example.service.dto.RechargeProducerDTO;

@Service
public class RechargeService {

	private final RabbitTemplate rabbitTemplate;
	
	Set<String> set = new HashSet<>();
	
	public RechargeService(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public String sendRechargeRequest(RechargeProducerDTO dto) {
		if(!set.contains(dto.getMobileNumber())) {			
			set.add(dto.getMobileNumber());
			rabbitTemplate.convertAndSend(RabbitConfig.Queue_Name, dto);
			return "message has been sent to broker";
		}
		
		else {
			return "only one time you can request";
		}
		
		
	}
	
	
	
}
