package com.rajlee.crudoperations.test;

import com.rajlee.crudoperations.model.Customer;
import com.rajlee.crudoperations.repository.CustomerRepository;
import com.rajlee.crudoperations.service.CustomerService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringBootMockitoApplicationTest {
    
    @Autowired
    private CustomerService customerService;
    
    @MockBean
    private CustomerRepository customerRepository;
    
    public void getCustomersTest(){
        when(customerRepository.findAll()).thenReturn(Stream.of(new Customer(6,"Humpy","UP"),
                new Customer(7,"Siri","Hyd")).collect(Collectors.toList()));
        assertEquals(2,customerService.getCustomers().size());
    }
}
