package com.springbasics;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //Hey Spring, this class contains configuration for the IOC container.
@ComponentScan(basePackages = "com.springbasics") // this tells go inside com package and scan all the components Any class with these → Spring creates object (bean).
public class DemoConfiguration {
	
	@Bean
	public Scanner getScanner() {
		return new Scanner(System.in);
	}
	
	@Bean
	public List<String> getList(){
		return List.of("nani", "puneeth", "mohan");
	}
	
	@Bean
	public Map<Integer, String> getMap(){
		
		Map<Integer, String> map = new LinkedHashMap<>();

		map.put(1, "nani");
		map.put(2, "puneeth");
		map.put(3, "mohan");
		
		return map;
		
	}
	
}
