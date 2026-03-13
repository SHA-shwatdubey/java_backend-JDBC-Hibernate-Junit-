package pom.capgemini;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pom.capgemini.controller.EmployeeController;
import pom.capgemini.entity.Employee;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Spring Context Initialize
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n=== Spring Application Started ===\n");

        // Get EmployeeController
        EmployeeController controller = context.getBean(EmployeeController.class);

        // Add Employees
        System.out.println("--- Adding Employees ---");
        controller.addEmployee(new Employee("John", 50000.0));
        controller.addEmployee(new Employee("Priya", 45000.0));
        controller.addEmployee(new Employee("Amit", 55000.0));

        // Get All Employees
        System.out.println("\n--- All Employees ---");
        List<Employee> employees = controller.getAllEmployees();
        employees.forEach(System.out::println);

        // Get Single Employee
        System.out.println("\n--- Get Employee by ID ---");
        Employee emp = controller.getEmployee(1);
        System.out.println(emp);

        System.out.println("\n=== Done ===\n");
    }
}

