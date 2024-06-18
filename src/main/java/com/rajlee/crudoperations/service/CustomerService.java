package com.rajlee.crudoperations.service;

import com.rajlee.crudoperations.model.Customer;
import com.rajlee.crudoperations.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;


    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> saveCustomers(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }

    public List<Customer> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        System.out.println("Getting data from db"+customers);
        return customers;
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

//    public List<Customer> getCustomerByName(String name) {
//        return customerRepository.findByName(name);
//    }

    public String deleteCustomer(int id){
        customerRepository.deleteById(id);
        return "customer removed"+id;
    }
}
