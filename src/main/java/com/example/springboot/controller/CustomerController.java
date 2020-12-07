package com.example.springboot.controller;

import com.example.springboot.entity.Customer;
import com.example.springboot.services.CustomerService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String getCustomerList() {
        return new Gson().toJson(customerService.findAll());
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addCustomer(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "age", required = true) Integer age, @RequestParam(value = "sex", required = true) String sex) {
        Customer customer = new Customer(null, name, age, sex);
        customerService.addCustomer(customer);
        return "姓名：" + name + "，年龄：" + age + "，性别：" + sex;
    }
}
