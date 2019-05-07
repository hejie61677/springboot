package com.hejie.springboot.mapper;

import com.hejie.springboot.pojo.Phone;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: springboot
 * @description: phone_test映射类
 * @author: hejie
 * @create: 2019-05-06 16:12
 */
@Mapper
public interface PhoneMapper {

    //注解方式
    @Select("select * from phone_test")
    List<Phone> findAll();

    @Insert("insert into phone_test (name, price) values (#{name}, #{price})")
    int save(Phone phone);

    @Delete("delete from phone_test where id = #{id}")
    void delete(int id);

    @Select("select * from phone_test where id = #{id}")
    Phone get(int id);

    @Update("update phone_test set name = #{name}, price = #{price} where id=  #{id}")
     int update(Phone phone);

}
