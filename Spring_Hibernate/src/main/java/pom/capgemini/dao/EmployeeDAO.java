package pom.capgemini.dao;

import pom.capgemini.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    void save(Employee employee);
    Employee findById(Integer id);
    List<Employee> findAll();
}


