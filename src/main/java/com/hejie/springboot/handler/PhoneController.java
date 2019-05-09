package com.hejie.springboot.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hejie.springboot.config.Page4Navigator;
import com.hejie.springboot.mapper.PhoneMapper;
import com.hejie.springboot.pojo.Phone;
import com.hejie.springboot.pojo.PhoneEntity;
import com.hejie.springboot.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    //mybatis方式 restful风格
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

    //JPA方式 调用Service接口
    @Autowired private PhoneService phoneService;

    /**
     * @Description: 列表查询 restful风格
     * @Param: Model, int, int
     * @return: String
     * @Author: hejie
     * @date: 2019/5/8
     */
    @GetMapping("/phoneRedis")
    public String categoryList(Model model, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "3") int size) {

        start = start < 0 ? 0 : start;
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page4Navigator<PhoneEntity> page = phoneService.list(pageable);
        model.addAttribute("page", page);
        return "phoneRedisList";
    }

    /**
     * @Description: 增加  restful风格
     * @Param: PhoneEntity
     * @return: String
     * @Author: hejie
     * @date: 2019/5/8
     */
    @PostMapping("/phoneRedis")
    public String categoryAdd(PhoneEntity phoneEntity) {

        phoneService.save(phoneEntity);
        return "redirect:/phoneRedis";
    }

    /**
     * @Description: 删除  restful风格
     * @Param: PhoneEntity
     * @return: String
     * @Author: hejie
     * @date: 2019/5/8
     */
    @DeleteMapping("/phoneRedis/{id}")
    public String categoryDelete(PhoneEntity phoneEntity) {

        phoneService.delete(phoneEntity.getId());
        return "redirect:/phoneRedis";
    }

    /**
     * @Description: 修改前查询  restful风格
     * @Param: int, Model
     * @return: String
     * @Author: hejie
     * @date: 2019/4/18
     */
    @GetMapping("/phoneRedis/{id}")
    public String categoryEdit(@PathVariable("id") int id, Model model) {

        PhoneEntity phoneEntity = phoneService.get(id);
        model.addAttribute("phone", phoneEntity);
        return "phoneRedisEdit";
    }

    /**
     * @Description: 修改  restful风格
     * @Param: PhoneEntity
     * @return: String
     * @Author: hejie
     * @date: 2019/4/18
     */
    @PutMapping("/phoneRedis/{id}")
    public String categoryUpdate(PhoneEntity phoneEntity) {

        phoneService.save(phoneEntity);
        return "redirect:/phoneRedis";
    }

}
