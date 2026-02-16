package com.prac;

public class Calculator {
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static String reverseString(String str) {
		if(str == null) {
			return null;
		}
		StringBuilder strb = new StringBuilder();
		return strb.append(str).reverse().toString();
	}
	
	public static boolean isPalindrome(String res) {
		if(res == null) return false;
		String original = res;
		StringBuilder strb = new StringBuilder();
		String revers = strb.append(res).reverse().toString();
		return original.equals(revers);
	}
	
	public static int factorial(int num) {
		int fact = 1;
		if(num == 0 || num == 1) return 1;
		for(int i = 1; i <= num; i++) {
			fact *= i;
		}
		return fact;
	}
	
	public static boolean isEmail(String mail) {
		return mail.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com");
	}

	public static int div(int a, int b) {
		return (a / b);
	}
	
}
