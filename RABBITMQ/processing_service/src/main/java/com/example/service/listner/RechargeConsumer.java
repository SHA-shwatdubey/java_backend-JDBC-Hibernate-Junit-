package com.example.service.listner;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.service.config.RabbitConfig;
import com.example.service.dto.RechargeProducerDTO;

@Component
public class RechargeConsumer {

	@RabbitListener(queues = RabbitConfig.Queue_Name)
	public void processRecharge(RechargeProducerDTO dto) throws InterruptedException {
		System.out.println("message received from queue");
		System.out.println("Recharge processing from mobile " + dto.getMobileNumber());
		Thread.sleep(5000);
	}
	
}
