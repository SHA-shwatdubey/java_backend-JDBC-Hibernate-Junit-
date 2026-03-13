package pom.capgemini;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ========================================================
 * @Component + @Value ANNOTATION DEMONSTRATION
 * ========================================================
 *
 * @Component - Ye annotation Employee class ko Spring bean banata hai
 *
 * @Value - Ye annotation properties aur values inject karta hai
 *
 * @Value Ke Different Ways:
 * 1. @Value("hardcoded value") - Direct value
 * 2. @Value("${property.name}") - Property file se value
 * 3. @Value("${property.name:defaultValue}") - Default value ke saath
 * 4. @Value("#{expression}") - SpEL expression
 *
 * Ye example demonstrate karta hai kaise @Value se values inject karte hain
 * ========================================================
 */
@Component
public class Employee {

    /**
     * @Value("0") - Hardcoded default value
     * Jab koi property file mein nahi hota, ye value use hoga
     *
     * Spring automatically is value ko id field mein inject karega
     */
    @Value("0")
    private int id;

    /**
     * @Value with default value syntax
     * Agar property file mein "employee.name" nahi hota,
     * to "Unassigned Employee" use hoga
     *
     * Syntax: @Value("${propertyName:defaultValue}")
     */
    @Value("${employee.name:Unassigned Employee}")
    private String name;

    /**
     * @Value with hardcoded default
     * Direct hardcoded value 0.0
     *
     * Spring automatically is value ko salary field mein inject karega
     */
    @Value("0.0")
    private double salary;

    // Default Constructor - Spring beans banane ke liye jaruri hai
    public Employee() {
        this.id = 0;
        this.name = "Unknown";
        this.salary = 0.0;
    }

    // Getters aur Setters - Data access aur modify karne ke liye
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Employee ki details print karne ke liye
    public void msg() {
        System.out.println("Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]");
    }
}

