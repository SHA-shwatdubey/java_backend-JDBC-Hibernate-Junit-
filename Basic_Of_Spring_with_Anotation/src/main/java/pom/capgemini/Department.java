package pom.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ========================================================
 * @Component + @Autowired + @Value ANNOTATION DEMONSTRATION
 * ========================================================
 *
 * @Component - Ye class bhi Spring bean ban jayegi
 *
 * @Autowired - Automatic Dependency Injection
 * Spring automatically Person aur Employee objects inject kar dega
 * Hume manually set nahi karna padega
 *
 * @Value - Properties/Values inject karna
 * Default values ya property file se values le sakte hain
 * ========================================================
 */
@Component
public class Department {

    /**
     * @Value("IT Department") - Default department name
     * Spring automatically ye value inject karega
     */
    @Value("${department.name:IT Department}")
    private String departmentName;

    /**
     * @Value("50") - Default employee count
     */
    @Value("${department.employee.count:50}")
    private int employeeCount;

    /**
     * @Value("500000") - Department budget
     */
    @Value("${department.budget:500000}")
    private double departmentBudget;

    // @Autowired on field - Field Injection
    // Spring automatically Person bean inject kar dega
    @Autowired
    private Person person;

    // Employee object - constructor injection ke through aayega
    private Employee employee;

    public Department() {
        this.departmentName = "IT Department";
        System.out.println("Department object created by Spring!");
    }

    /**
     * @Autowired on Constructor - Constructor Injection (Recommended)
     * Spring automatically Employee bean inject karega
     * Ye sabse best practice hai
     */
    @Autowired
    public Department(Employee employee) {
        this.departmentName = "IT Department";
        this.employee = employee;
        System.out.println("Department created with Employee dependency!");
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    // Getters for @Value injected fields
    public int getEmployeeCount() {
        return employeeCount;
    }

    public double getDepartmentBudget() {
        return departmentBudget;
    }

    public void showDepartmentInfo() {
        System.out.println("\n========== Department Information ==========");
        System.out.println("Department: " + departmentName);
        System.out.println("\n--- Person Details ---");
        if (person != null) {
            person.display();
        } else {
            System.out.println("No person assigned");
        }
        System.out.println("\n--- Employee Details ---");
        if (employee != null) {
            employee.msg();
        } else {
            System.out.println("No employee assigned");
        }
        System.out.println("===========================================\n");
    }
}
