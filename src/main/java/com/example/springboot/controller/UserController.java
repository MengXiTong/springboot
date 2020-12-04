package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.services.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private static final String USER_LIST_PATH_NAME = "userList";

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

    //这个用于JSP
    @RequestMapping(value = "/query1", method = RequestMethod.GET)
    public String getUserList1(ModelMap modelMap){
        modelMap.addAttribute("userList", userService.findAll());
        return USER_LIST_PATH_NAME;
    }

}
