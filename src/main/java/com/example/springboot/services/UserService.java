package com.example.springboot.services;

import com.example.springboot.entity.User;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(String username, Integer age) {
        System.out.println("插入一条数据");
        jdbcTemplate.update("insert into user values(?,?)", username, age);
    }

    public String queryUserList() {
        String sql = "select * from user";
        List<User> users = jdbcTemplate.query(sql, new MyRowMapper());
        return new Gson().toJson(users);
    }

    public List<User> findAll() {
        String sql = "select * from user";
        //使用BeanPropertyRowMapper的注意：字段名字一样或者驼峰式与下划线式对应
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }
}

class MyRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        String username = resultSet.getString("username");
        Integer age = resultSet.getInt("age");
        User user = new User(username, age);
        return user;
    }
}
