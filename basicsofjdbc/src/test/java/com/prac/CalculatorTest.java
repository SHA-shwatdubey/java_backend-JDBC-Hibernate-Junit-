package com.prac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
//	Normal assertions → compare values → no lambda
//	Exception assertion → control execution → lambda required

	
	public void addTest() {
		int res = Calculator.add(20, 30);
		assertEquals(50, res);
	}
	
	@Test
	public void reverseTest() {
		String actualRes = Calculator.reverseString("data");
		assertEquals("atad", actualRes);
	}
	
	@Test
	public void reverseTestNull() {
		String actualRes = Calculator.reverseString(null);
		assertEquals(null, actualRes);
	}
	
	@Test
	public void isPalindromeTest() {
		boolean res = Calculator.isPalindrome("naman");
		assertEquals(true, res);
	}
	
	@Test
	public void factorialTest() {
		int res = Calculator.factorial(3);
		assertEquals(6, res);
	}
	
	@Test
	public void testValidAge() {
		Employee e = new Employee(10, "puneeth", 18, "dept");
		
		assertTrue(e.isValidAge());
	}
	
	@Test
	public void checkDept() {
		Employee e = new Employee(10, "puneeth", 18, "dep#t");
		assertFalse(e.checkDept());
	}
	
	@Test
	public void testException() {
		Calculator c = new Calculator();
		assertThrows(ArithmeticException.class, () -> {c.div(10, 0);});
	}
	
}
