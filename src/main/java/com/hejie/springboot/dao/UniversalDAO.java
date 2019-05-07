package com.hejie.springboot.dao;

import com.hejie.springboot.pojo.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
  * @program: springboot
  * @description: 通用持久层接口（继承JpaRepository接口）
  * @author: hejie
  * @create: 2019/5/6
  */
public interface UniversalDAO extends JpaRepository<CategoryEntity, Integer> {
}
