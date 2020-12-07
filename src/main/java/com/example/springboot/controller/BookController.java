package com.example.springboot.controller;

import com.example.springboot.entity.JPABook;
import com.example.springboot.services.JPABookService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/book")
public class BookController {

    @Autowired
    private JPABookService jpaBookService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBook(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "writer", required = true) String writer, @RequestParam(value = "introduction", required = true) String introduction) {
        JPABook jpaBook = new JPABook(name, writer, introduction);
        jpaBookService.insertByBook(jpaBook);
        return "书名：" + name + "，作者：" + writer + "，简介：" + introduction;
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String getBookList() {
        return new Gson().toJson(jpaBookService.findAll());
    }
}
