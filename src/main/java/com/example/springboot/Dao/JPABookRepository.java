package com.example.springboot.Dao;

import com.example.springboot.entity.JPABook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPABookRepository extends JpaRepository<JPABook, Long> {
}
