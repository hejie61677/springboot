package com.hejie.springboot.handler;

import com.hejie.springboot.dao.CategoryDAO;
import com.hejie.springboot.mapper.CategoryMapper;
import com.hejie.springboot.pojo.Category;
import com.hejie.springboot.pojo.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
  * @program: springboot
  * @description:
  * @author: hejie
  * @create: 2019/4/18
  */
@Controller
public class CategoryController {

    //JPA方式
    @Autowired CategoryDAO categoryDAO;

    /**
      * @Description:
      * @Param: Model
      * @return: String
      * @Author: hejie
      * @date: 2019/4/18
      */
    @RequestMapping("/categoryList1")
    public String categoryList1(Model model, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) {

        start = start < 0 ? 0 : start;
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<CategoryEntity> page = categoryDAO.findAll(pageable);
        model.addAttribute("page", page);
        return "categoryList1";
    }

    @RequestMapping("/addCategory1")
    public String addCategory(CategoryEntity categoryEntity){

        categoryDAO.save(categoryEntity);
        return "redirect:categoryList1";
    }

    @RequestMapping("/deleteCategory1")
    public String deleteCategory(CategoryEntity categoryEntity){

        categoryDAO.delete(categoryEntity);
        return "redirect:categoryList1";
    }

    @RequestMapping("/editCategory1")
    public String editCategory(int id, Model model){

        CategoryEntity categoryEntity = categoryDAO.getOne(id);
        model.addAttribute("category", categoryEntity);
        return "editCategory1";
    }

    @RequestMapping("/updateCategory1")
    public String updateCategory(CategoryEntity categoryEntity){

        categoryDAO.save(categoryEntity);
        return "redirect:categoryList1";
    }
    
    //mybatis方式
    @Autowired CategoryMapper categoryMapper;

    /**
      * @Description:
      * @Param: Moder
      * @return: String
      * @Author: hejie
      * @date: 2019/4/18
      */
    @RequestMapping("/categoryList2")
    public String categoryList2(Model model) {

        List<Category> list = categoryMapper.findAll();
        model.addAttribute("list", list);
        return "categoryList2";
    }

}
