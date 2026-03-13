package com.springbasics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("config.xml");

		Person person = ioc.getBean("person", Person.class);
		
		person.message();
		
		System.out.println("\n======== Employee ===========\n");
		
		Employee employee = ioc.getBean("employee", Employee.class);
		
//		employee.setId(1);
		employee.setName("nani");
		employee.setSalary(10000);
		
		System.out.println(employee);
		
	}

}
