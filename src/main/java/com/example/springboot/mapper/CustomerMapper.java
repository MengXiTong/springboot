package com.example.springboot.mapper;

import com.example.springboot.entity.Customer;

import java.util.List;

public interface CustomerMapper {
    List<Customer> findAll();

    void insertByCustomer(Customer customer);
}
