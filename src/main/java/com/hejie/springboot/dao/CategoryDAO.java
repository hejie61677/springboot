package com.hejie.springboot.dao;

import com.hejie.springboot.pojo.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
  * @program: springboot
  * @description: 继承JpaRepository接口的简单持久层接口
  * @author: hejie
  * @create: 2019/4/18
  */
public interface CategoryDAO extends JpaRepository<CategoryEntity, Integer> {
}
