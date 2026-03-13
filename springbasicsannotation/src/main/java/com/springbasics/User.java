package com.springbasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class User {
	
	@Autowired
	@Qualifier("creditCard") // this takes over primary
	private Payment payment;
	
	public void display() {
		payment.send();
	}
	
	public static void main(String[] args) {
		ApplicationContext ac =
			    new AnnotationConfigApplicationContext(DemoConfiguration.class);		
		User u = ac.getBean(User.class);
		u.display();
		
	}
	
}
