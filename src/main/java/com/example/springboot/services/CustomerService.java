package com.example.springboot.services;

import com.example.springboot.entity.Customer;
import com.example.springboot.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    public List<Customer> findAll() {
        return customerMapper.findAll();
    }

    public void addCustomer(Customer customer) {
        customerMapper.insertByCustomer(customer);
    }
}
