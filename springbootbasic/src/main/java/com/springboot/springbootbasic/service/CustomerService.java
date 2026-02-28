package com.springboot.springbootbasic.service;

import com.springboot.springbootbasic.entity.Customer;
import com.springboot.springbootbasic.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // CREATE
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // READ - Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // READ - Get customer by ID
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    // UPDATE
    public Customer updateCustomer(Long id, Customer customerDetails) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            Customer existingCustomer = customer.get();
            existingCustomer.setName(customerDetails.getName());
            existingCustomer.setEmail(customerDetails.getEmail());
            existingCustomer.setPhone(customerDetails.getPhone());
            existingCustomer.setAddress(customerDetails.getAddress());
            return customerRepository.save(existingCustomer);
        }
        return null;
    }

    // DELETE
    public boolean deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

