package com.hejie.springboot.test;

import com.hejie.springboot.SpringbootApplication;
import com.hejie.springboot.dao.CategoryDAO;
import com.hejie.springboot.pojo.CategoryEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @program: springboot
 * @description: junit test
 * @author: hejie
 * @create: 2019-04-26 14:41
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class TestJPA {

    @Autowired CategoryDAO categoryDAO;

    @Test
    public void test() {
        List<CategoryEntity> list =  categoryDAO.findAll();
        for (CategoryEntity categoryEntity : list) {
            System.out.println("name : " + categoryEntity.getName());
        }

    }
}
