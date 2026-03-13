package com.springbasics;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class UPI implements Payment{
	
	@Override
	public void send() {
		System.out.println("UPI send");
	}
	
}
