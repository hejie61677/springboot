package com.hejie.springboot.mapper;

import com.hejie.springboot.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: springboot
 * @description:
 * @author: hejie
 * @create: 2019-04-18 15:27
 */
@Mapper
public interface CategoryMapper {

    //注解方式
    @Select("select * from category_test")
    List<Category> findAll();

}
