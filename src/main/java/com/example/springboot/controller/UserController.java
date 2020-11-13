package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.services.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@RequestParam(value = "username", required = true) String username, @RequestParam(value = "age", required = true) Integer age) {
        userService.addUser(username, age);
        return "姓名：" + username + "，年龄：" + age;
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String getUserList(){
        return userService.queryUserList();
    }
}
