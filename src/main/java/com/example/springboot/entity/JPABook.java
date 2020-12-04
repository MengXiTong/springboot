package com.example.springboot.entity;


import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class JPABook {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 书名
     */
    @Nullable
    @Column(name = "name")
    private String name;

    /**
     * 作者
     */
    @Nullable
    @Column(name = "writer")
    private String writer;

    /**
     * 简介
     */
    @Nullable
    @Column(name = "introduction")
    private String introduction;

    public JPABook() {
    }

    public JPABook(String name, String writer, String introduction) {
        this.name = name;
        this.writer = writer;
        this.introduction = introduction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
