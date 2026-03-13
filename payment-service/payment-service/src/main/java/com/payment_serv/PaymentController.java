package com.payment_serv;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

	
	@GetMapping("/options")
	public List<String> paymentOption() {

		
		return List.of("UPI", "NetBanking", "CreditCard", "DebitCard");
	}

	
	
}
