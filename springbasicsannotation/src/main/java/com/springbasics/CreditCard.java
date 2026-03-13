package com.springbasics;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CreditCard implements Payment{
	@Override
	public void send() {
		System.out.println("credit card send");
	}
}
