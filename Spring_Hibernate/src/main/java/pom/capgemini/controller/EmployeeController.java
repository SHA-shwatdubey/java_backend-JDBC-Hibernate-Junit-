package pom.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import pom.capgemini.service.EmployeeService;
import pom.capgemini.entity.Employee;
import java.util.List;

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
        System.out.println("Employee Added: " + employee);
    }

    public Employee getEmployee(Integer id) {
        return employeeService.getEmployeeById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}

