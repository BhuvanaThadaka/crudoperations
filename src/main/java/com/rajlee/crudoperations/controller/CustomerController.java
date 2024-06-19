package com.rajlee.crudoperations.controller;

import com.rajlee.crudoperations.model.Customer;
import com.rajlee.crudoperations.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CustomerController {

    @Autowired
    CustomerService customerService;


    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PostMapping("/addCustomers")
    public List<Customer> addCustomers(@RequestBody List<Customer> customers) {
        return customerService.saveCustomers(customers);
    }

    @GetMapping("/customer/{id}")
    public Customer findById(@PathVariable("id") int id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/customers")
    public List<Customer> findAllCustomers() {
        return customerService.getCustomers();
    }

//    @GetMapping("/customer/{name}")
//    public List<Customer> findByName(@PathVariable("name") String name) {
//        return customerService.getCustomerByName(name);
//    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return customerService.deleteCustomer(id);
    }
}
