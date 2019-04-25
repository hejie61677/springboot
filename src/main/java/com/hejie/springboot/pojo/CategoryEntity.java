package com.hejie.springboot.pojo;

import javax.persistence.*;

/**
  * @program: springboot
  * @description: category_test实体类
  * @author: hejie
  * @create: 2019/4/18
  */
@Entity
@Table(name = "category_test")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
