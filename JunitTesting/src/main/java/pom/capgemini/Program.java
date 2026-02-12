package pom.capgemini;

public class Program {

    // Palindrome Method
    public boolean isPalindrome(String str) {

        if (str == null) {
            return false;
        }

        StringBuilder s = new StringBuilder(str);

        return s.reverse().toString().equals(str);
    }

    // Positive Check
    public boolean isPositive(int number) {
        return number > 0;
    }

    // Add Method
    public int add(int a, int b) {
        return a + b;
    }
}
