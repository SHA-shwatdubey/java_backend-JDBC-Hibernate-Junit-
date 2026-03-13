package pom.capgemini.service;

import pom.capgemini.entity.Employee;
import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    Employee getEmployeeById(Integer id);
    List<Employee> getAllEmployees();
}


