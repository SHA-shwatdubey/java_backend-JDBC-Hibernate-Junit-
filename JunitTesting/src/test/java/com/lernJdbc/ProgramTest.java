package com.lernJdbc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import pom.capgemini.EvenOrOdd;
import pom.capgemini.Program;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramTest {

    @ParameterizedTest
    @ValueSource(strings = {"tenet", "radar", "aba"})
    void isPalindromeTest(String str) {
        Program p = new Program();
        assertTrue(p.isPalindrome(str));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void isPositiveTest(int number) {
        Program p = new Program();
        assertTrue(p.isPositive(number));
    }

    @ParameterizedTest
    @CsvSource({
            "2,3,5",
            "10,20,30",
            "-5,5,0"
    })
    void addTest(int a, int b, int expected) {
        Program p = new Program();
        assertEquals(expected, p.add(a, b));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/exal.csv", numLinesToSkip = 1)
    public  void  evenoroddTest(String input,String expected){
        EvenOrOdd eoo=new EvenOrOdd();
        String actualres=eoo.evenOrOdd(Integer.parseInt(input));
        assertEquals(expected,actualres);
    }
}
