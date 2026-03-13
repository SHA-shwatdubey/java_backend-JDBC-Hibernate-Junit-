package com.user_service.repo;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("PAYMENT-SERV")
public interface PaymentFeignClient {

	@GetMapping("/payment/options")
	public List<String> paymentOption();
	
}
