package com.hejie.springboot.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
  * @program: springboot
  * @description: Category处理器类
  * @author: hejie
  * @create: 2019/4/18
  */
@Controller
public class CategoryController {

    //JPA方式
    @Autowired private CategoryDAO categoryDAO;

    /**
      * @Description: 列表查询 restful风格
      * @Param: Model, int, int
      * @return: String
      * @Author: hejie
      * @date: 2019/4/18
      */
    @GetMapping("/category")
    public String categoryList(Model model, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "3") int size) {

        start = start < 0 ? 0 : start;
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<CategoryEntity> page = categoryDAO.findAll(pageable);
        model.addAttribute("page", page);
        return "categoryList";
    }

    /**
     * @Description: 增加  restful风格
     * @Param: CategoryEntity
     * @return: String
     * @Author: hejie
     * @date: 2019/4/18
     */
    @PostMapping("/category")
    public String categoryAdd(CategoryEntity categoryEntity) {

        categoryDAO.save(categoryEntity);
        return "redirect:/category";
    }

    /**
     * @Description: 删除  restful风格
     * @Param: CategoryEntity
     * @return: String
     * @Author: hejie
     * @date: 2019/4/18
     */
    @DeleteMapping("/category/{id}")
    public String categoryDelete(CategoryEntity categoryEntity) {

        categoryDAO.delete(categoryEntity);
        return "redirect:/category";
    }

    /**
     * @Description: 修改前查询  restful风格
     * @Param: int, Model
     * @return: String
     * @Author: hejie
     * @date: 2019/4/18
     */
    @GetMapping("/category/{id}")
    public String categoryEdit(@PathVariable("id") int id, Model model) {

        CategoryEntity categoryEntity = categoryDAO.getOne(id);
        model.addAttribute("category", categoryEntity);
        return "categoryEdit";
    }

    /**
     * @Description: 修改  restful风格
     * @Param: CategoryEntity
     * @return: String
     * @Author: hejie
     * @date: 2019/4/18
     */
    @PutMapping("/category/{id}")
    public String categoryUpdate(CategoryEntity categoryEntity) {

        categoryDAO.save(categoryEntity);
        return "redirect:/category";
    }

    /**
     * @Description: 列表查询
     * @Param: Model, int, int
     * @return: String
     * @Author: hejie
     * @date: 2019/4/18
     */
    @RequestMapping("/categoryList1")
    public String categoryList1(Model model, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "3") int size) {

        start = start < 0 ? 0 : start;
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<CategoryEntity> page = categoryDAO.findAll(pageable);
        model.addAttribute("page", page);
        return "categoryList1";
    }

    /**
     * @Description: 增加
     * @Param: CategoryEntity
     * @return: String
     * @Author: hejie
     * @date: 2019/4/18
     */
    @RequestMapping("/addCategory1")
    public String addCategory1(CategoryEntity categoryEntity) {

        categoryDAO.save(categoryEntity);
        return "redirect:categoryList1";
    }

    /**
     * @Description: 删除
     * @Param: CategoryEntity
     * @return: String
     * @Author: hejie
     * @date: 2019/4/18
     */
    @RequestMapping("/deleteCategory1")
    public String deleteCategory1(CategoryEntity categoryEntity) {

        categoryDAO.delete(categoryEntity);
        return "redirect:categoryList1";
    }

    /**
     * @Description: 修改前查询
     * @Param: int, Model
     * @return: String
     * @Author: hejie
     * @date: 2019/4/18
     */
    @RequestMapping("/editCategory1")
    public String editCategory1(int id, Model model) {

        CategoryEntity categoryEntity = categoryDAO.getOne(id);
        model.addAttribute("category", categoryEntity);
        return "editCategory1";
    }

    /**
     * @Description: 修改
     * @Param: CategoryEntity
     * @return: String
     * @Author: hejie
     * @date: 2019/4/18
     */
    @RequestMapping("/updateCategory1")
    public String updateCategory1(CategoryEntity categoryEntity) {

        categoryDAO.save(categoryEntity);
        return "redirect:categoryList1";
    }
    
    //mybatis方式
    @Autowired private CategoryMapper categoryMapper;

    /**
      * @Description: 列表查询
      * @Param: Model, int, int
      * @return: String
      * @Author: hejie
      * @date: 2019/4/20
      */
    @RequestMapping("/categoryList2")
    public String categoryList2(Model model, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "3") int size) {

        PageHelper.startPage(start, size, "id desc");
        List<Category> list = categoryMapper.findAll();
        PageInfo<Category> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "categoryList2";
    }

    /**
     * @Description: 新增
     * @Param: Category
     * @return: String
     * @Author: hejie
     * @date: 2019/4/20
     */
    @RequestMapping("/addCategory2")
    public String addCategory2(Category category) {

        categoryMapper.save(category);
        return "redirect:categoryList2";
    }

    /**
     * @Description: 删除
     * @Param: Category
     * @return: String
     * @Author: hejie
     * @date: 2019/4/20
     */
    @RequestMapping("/deleteCategory2")
    public String deleteCategory2(Category category) {

        categoryMapper.delete(category.getId());
        return "redirect:categoryList2";
    }

    /**
     * @Description: 修改前查询
     * @Param: int, Model
     * @return: String
     * @Author: hejie
     * @date: 2019/4/20
     */
    @RequestMapping("/editCategory2")
    public String listCategory(int id, Model model) {

        Category category = categoryMapper.get(id);
        model.addAttribute("category", category);
        return "editCategory2";
    }

    /**
     * @Description: 修改
     * @Param: Category
     * @return: String
     * @Author: hejie
     * @date: 2019/4/20
     */
    @RequestMapping("/updateCategory2")
    public String updateCategory(Category category) {

        categoryMapper.update(category);
        return "redirect:categoryList2";
    }

}
