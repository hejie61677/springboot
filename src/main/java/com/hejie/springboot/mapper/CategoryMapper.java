package com.hejie.springboot.mapper;

import com.hejie.springboot.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: springboot
 * @description: Category映射类
 * @author: hejie
 * @create: 2019-04-18 15:27
 */
@Mapper
public interface CategoryMapper {

    //注解方式
    @Select("select * from category_test")
    List<Category> findAll();

    @Insert("insert into category_test (name) values (#{name})")
    int save(Category category);

    @Delete("delete from category_test where id= #{id}")
    void delete(int id);

    @Select("select * from category_test where id= #{id}")
    Category get(int id);

    @Update("update category_test set name=#{name} where id=#{id}")
     int update(Category category);

}
