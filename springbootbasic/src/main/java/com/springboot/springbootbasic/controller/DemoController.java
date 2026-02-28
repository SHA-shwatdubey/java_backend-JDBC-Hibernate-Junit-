package com.springboot.springbootbasic.controller;

import com.springboot.springbootbasic.entity.Car;
import com.springboot.springbootbasic.entity.College;
import com.springboot.springbootbasic.entity.Student;
import com.springboot.springbootbasic.entity.Customer;
import com.springboot.springbootbasic.model.Cricketer;
import com.springboot.springbootbasic.model.Person;
import com.springboot.springbootbasic.service.CollegeService;
import com.springboot.springbootbasic.service.StudentService;
import com.springboot.springbootbasic.service.CarService;
import com.springboot.springbootbasic.service.CustomerService;
import com.springboot.springbootbasic.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
//@Controller
public class DemoController {

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CarService carService;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerService customerService;

    //    @GetMapping("/a")
//    public List<String> getA(){
//        List<String> list=new ArrayList
//       <>();
//        list.add("Hello");
//        list.add("World");
//        list.add("hello Shahswat");
//        return list;
//    }
    @GetMapping("/a")
    public List<String> getA() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("hello Shahswat");
        return list;
    }

    @PostMapping("/add")
    public String createPlayer(@RequestBody Cricketer c) {
        return c.toString();
    }


    @PostMapping("/Car")
    public String createCar(@RequestBody Car car) {
        Car savedCar = carService.saveCar(car);
        System.out.println(savedCar);
        return savedCar.toString();
    }

    @PostMapping("/person")
    public String createPerson(@RequestBody Person person) {
        System.out.println(person);
        return person.toString();
    }

    @PostMapping("/student")
    public String createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        System.out.println(savedStudent);
        return savedStudent.toString();
    }

    @PostMapping("/college")
    public String createCollege(@RequestBody College college) {
        College savedCollege = collegeService.saveCollege(college);
        System.out.println(savedCollege);
        return savedCollege.toString();
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/colleges")
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    @GetMapping("/find-id")
    public String getById(@RequestParam Long id) {
        Optional<Car> option = carRepository.findById(id);
        return option.map(Car::toString).orElse("Data not found");
    }

    // ============ CUSTOMER CRUD OPERATIONS ============

    // CREATE - Add new customer
    @PostMapping("/customer")
    public String createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveCustomer(customer);
        System.out.println(savedCustomer);
        return savedCustomer.toString();
    }

    // READ - Get all customers
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // READ - Get customer by ID
    @GetMapping("/customer/{id}")
    public String getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        return (customer != null) ? customer.toString() : "Customer not found";
    }

    // UPDATE - Update customer by ID
    @PutMapping("/customer/{id}")
    public String updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(id, customer);
        return (updatedCustomer != null) ? updatedCustomer.toString() : "Customer not found";
    }

    // DELETE - Delete customer by ID
    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        boolean isDeleted = customerService.deleteCustomer(id);
        return isDeleted ? "Customer deleted successfully" : "Customer not found";
    }
}