package com.hejie.springboot.dao;

import com.hejie.springboot.pojo.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
  * @program: springboot
  * @description:
  * @author: hejie
  * @create: 2019/4/18
  */
public interface CategoryDAO extends JpaRepository<CategoryEntity, Integer> {
}
