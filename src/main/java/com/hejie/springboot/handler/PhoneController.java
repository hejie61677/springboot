package com.hejie.springboot.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hejie.springboot.mapper.PhoneMapper;
import com.hejie.springboot.pojo.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
  * @program: springboot
  * @description: Phone处理器类
  * @author: hejie
  * @create: 2019/5/6
  */
@Controller
public class PhoneController {

    //mybatis方式
    @Autowired private PhoneMapper phoneMapper;

    /**
     * @Description: 列表查询
     * @Param: Model, int, int
     * @return: String
     * @Author: hejie
     * @date: 2019/5/6
     */
    @GetMapping("/phone")
    public String phoneList(Model model, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "3") int size) {

        PageHelper.startPage(start, size, "id");
        List<Phone> list = phoneMapper.findAll();
        PageInfo<Phone> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "phoneList";
    }

    /**
     * @Description: 新增
     * @Param: Phone
     * @return: String
     * @Author: hejie
     * @date: 2019/5/6
     */
    @PostMapping("/phone")
    public String phoneAdd(Phone phone) {

        phoneMapper.save(phone);
        return "redirect:/phone";
    }

    /**
     * @Description: 删除
     * @Param: Phone
     * @return: String
     * @Author: hejie
     * @date: 2019/5/6
     */
    @DeleteMapping("/phone/{id}")
    public String phoneDelete(Phone phone) {

        phoneMapper.delete(phone.getId());
        return "redirect:/phone";
    }

    /**
     * @Description: 修改前查询
     * @Param: int, Model
     * @return: String
     * @Author: hejie
     * @date: 2019/5/6
     */
    @GetMapping("/phone/{id}")
    public String phoneEdit(@PathVariable("id") int id, Model model) {

        Phone phone = phoneMapper.get(id);
        model.addAttribute("phone", phone);
        return "phoneEdit";
    }

    /**
     * @Description: 修改
     * @Param: Phone
     * @return: String
     * @Author: hejie
     * @date: 2019/5/6
     */
    @PutMapping("/phone/{id}")
    public String phoneUpdate(Phone phone) {

        phoneMapper.update(phone);
        return "redirect:/phone";
    }

}
