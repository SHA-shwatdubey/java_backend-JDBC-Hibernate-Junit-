package pom.capgemini.util;

public class ValidationUtil {

    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean isValidName(String name) {
        return name != null && !name.isEmpty() && name.length() >= 2;
    }

    public static boolean isValidAge(Integer age) {
        return age != null && age >= 0 && age <= 150;
    }

    public static boolean isPositiveInteger(Integer value) {
        return value != null && value > 0;
    }
}

