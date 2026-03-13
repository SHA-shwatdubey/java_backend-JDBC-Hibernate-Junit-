package pom.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pom.capgemini.dao.EmployeeDAO;
import pom.capgemini.entity.Employee;
import pom.capgemini.service.EmployeeService;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    private EmployeeDAO employeeDAO;
    
    @Override
    public void addEmployee(Employee employee) {
        employeeDAO.save(employee);
    }
    
    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeDAO.findById(id);
    }
    
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }
}

