package pom.capgemini;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ========================================================
 * @Component + @Value ANNOTATION DEMONSTRATION
 * ========================================================
 *
 * @Component - Ye annotation class ko Spring bean bana deta hai
 * @Value - Default values ko inject karta hai
 *
 * @Value Examples:
 * - @Value("John") - Simple string value
 * - @Value("30") - Integer value
 * - @Value("${property:defaultValue}") - Property ke saath default
 *
 * Spring automatically isko scan karke bean banayega aur @Value se values inject karega
 * ========================================================
 */
@Component
public class Person {

    /**
     * @Value("Unknown Person") - Default name
     * Agar koi property file se value nahi aay, to ye default use hoga
     */

    @Value("Unknown Person")
    private String name;

    /**
     * @Value("0") - Default age
     * Integer type ke liye 0 se default set kiya hai
     */
    @Value("0")
    private int age;

    /**
     * @Value with default syntax
     * Agar property file mein "person.city" nahi hota,
     * to "Unknown City" use hoga
     */
    @Value("${person.city:Unknown City}")
    private String city;

    // Default Constructor
    public Person() {
        this.name = "Unknown Person";
        this.age = 0;
        this.city = "Unknown City";
    }

    // Parameterized Constructor
    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Display method
    public void display() {
        System.out.println("Person [name=" + name + ", age=" + age + ", city=" + city + "]");
    }
}

