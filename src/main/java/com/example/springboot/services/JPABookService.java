package com.example.springboot.services;

import com.example.springboot.dao.JPABookRepository;
import com.example.springboot.entity.JPABook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPABookService {
    @Autowired
    private JPABookRepository jpaBookRepository;

    public List<JPABook> findAll() {
        return jpaBookRepository.findAll();
    }

    public JPABook insertByBook(JPABook jpaBook) {
        return jpaBookRepository.save(jpaBook);
    }

    public JPABook update(JPABook jpaBook) {
        return jpaBookRepository.save(jpaBook);
    }

    public void delete(Long id) {
        jpaBookRepository.deleteById(id);
    }

    public JPABook findById(Long id) {
        return jpaBookRepository.getOne(id);
    }
}
