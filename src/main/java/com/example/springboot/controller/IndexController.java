package com.example.springboot.controller;

import com.example.springboot.entity.BaseResponse;
import com.example.springboot.entity.RequestLoginBean;
import com.example.springboot.entity.Student;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class IndexController {
    @RequestMapping(value = "/index")
    public Student index() {
        Student student = new Student("张三", "男", 12, "好人好人");
        return student;
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping(value = "/showpath/{name}")
    public String index1(@PathVariable String name) {
        return "oh you are " + name + "<br> nice to meet you";
    }

    @RequestMapping(value = "testpost", method = RequestMethod.POST)
    public String testpost() {
        System.out.println("hello  test post");
        return "OJBK";
    }

    @GetMapping(value = "/login/{name}&{pwd}")
    public String login(@PathVariable String name, @PathVariable String pwd) {
        if (name.equals("admin") && pwd.equals("123")) {
            return "hello welcome admin";
        } else {
            return "oh sorry user name or password is wrong";
        }
    }

    @RequestMapping(value = "/loginbyget", method = RequestMethod.GET)
    public String loginbyget(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "pwd", required = true) String pwd) {
        return login4Return(name, pwd);
    }

    @RequestMapping(value = "/loginbypost", method = RequestMethod.POST)
    public String loginbypost(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "pwd", required = true) String pwd) {
        return login4Return(name, pwd);
    }

    @RequestMapping(value = "/loginbypost1", method = {RequestMethod.POST, RequestMethod.GET})
    public String loginbypost1(RequestLoginBean loginBean) {
        if (loginBean != null) {
            return login4Return(loginBean.getName(), loginBean.getPwd());
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "loginbypost2", method = {RequestMethod.POST, RequestMethod.GET})
    public String loginbypost2(@RequestBody RequestLoginBean loginBean) {
        if (loginBean != null) {
            return login4Return(loginBean.getName(), loginBean.getPwd());
        } else {
            return "error";
        }
    }

    private String login4Return(String name, String pwd) {
        String result;
        BaseResponse response = new BaseResponse();
        if (name.equals("admin") && pwd.equals("123")) {
            result = "hello welcome admin";
            response.setState(true);
        } else {
            result = "oh sorry user name or password is wrong!";
            response.setState(false);
        }
        response.setResult(result);
        System.out.println("收到请求，请求结果" + result);
        return new Gson().toJson(response);
    }
}
