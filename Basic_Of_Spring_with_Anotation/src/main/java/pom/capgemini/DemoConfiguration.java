package pom.capgemini;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ===================================================================
 * SPRING ANNOTATIONS KI COMPLETE GUIDE - HINDI MEIN
 * ===================================================================
 *
 * 1. @Configuration - Ye class Spring ki configuration class hai
 *    - Isme @Bean methods aur @ComponentScan hota hai
 *    - Spring isko sabse pehle process karta hai
 *
 * 2. @ComponentScan - Spring ko batata hai ki kaha beans search karne hain
 *    - "pom.capgemini" package aur uske sub-packages mein search karega
 *    - @Component, @Service, @Repository annotated classes ko automatically detect karega
 *    - Automatically beans create kar dega
 *
 * 3. @Bean - Manual bean creation
 *    - Jab hume specific configuration chahiye
 *    - @ComponentScan se alag, manual control ke liye
 *
 * 4. @Value - Properties aur values inject karna
 *    - Hardcoded values inject kar sakte hain
 *    - Property files se values le sakte hain
 *    - Default values set kar sakte hain
 *    - SpEL (Spring Expression Language) expressions use kar sakte hain
 *
 * DIFFERENCE:
 * @Component -> Automatic bean creation (class level)
 * @Bean -> Manual bean creation (method level)
 * @Value -> Values/Properties inject karna
 * ===================================================================
 */
@Configuration
@ComponentScan(basePackages = "pom.capgemini")
public class DemoConfiguration {

    /**
     * @Value examples - Properties/Values inject karne ke liye
     *
     * @Value se hum hardcoded values inject kar sakte hain
     * These values are used in @Bean methods below
     */
    @Value("${company.name:Tech Solutions Inc.}")  // Default value bhi de sakte hain
    private String companyName;

    @Value("${company.city:Bangalore}")
    private String companyCity;

    @Value("${company.department:IT Department}")
    private String departmentName;

    /**
     * @Bean METHOD 1 - Manual bean creation
     *
     * Yaha hum manually Employee bean bana rahe hain specific values ke saath
     * Ye bean @Component wale Employee se ALAG hai
     *
     * Bean ka naam: "manualEmployee"
     */
    @Bean(name = "manualEmployee")
    public Employee employee1() {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("Rajesh Kumar");
        emp.setSalary(45000.0);
        System.out.println("Manual Employee bean created via @Bean method");
        return emp;
    }

    /**
     * @Bean METHOD 2 - Manager bean
     * Custom naam: "manager"
     */
    @Bean(name = "manager")
    public Employee createManager() {
        Employee manager = new Employee();
        manager.setId(101);
        manager.setName("Priya Sharma");
        manager.setSalary(85000.0);
        System.out.println("Manager bean created via @Bean method");
        return manager;
    }

    /**
     * @Bean METHOD 3 - Developer bean
     */
    @Bean(name = "developer")
    public Employee createDeveloper() {
        Employee dev = new Employee();
        dev.setId(25);
        dev.setName("Amit Singh");
        dev.setSalary(60000.0);
        System.out.println("Developer bean created via @Bean method");
        return dev;
    }

    /**
     * @Bean METHOD 4 - Person bean with specific values
     * Ye @Component wale Person se alag hai
     */
    @Bean(name = "manualPerson")
    public Person createPerson() {
        Person person = new Person();
        person.setName("Sanjay Gupta");
        person.setAge(35);
        person.setCity("Mumbai");
        System.out.println("Manual Person bean created via @Bean method");
        return person;
    }

}
