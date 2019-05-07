package com.hejie.springboot.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hejie.springboot.mapper.PhoneMapper;
import com.hejie.springboot.pojo.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
  * @program: springboot
  * @description: Phone处理器类
  * @author: hejie
  * @create: 2019/5/6
  */
@RestController
public class PhoneJsonController {

    //mybatis方式
    @Autowired private PhoneMapper phoneMapper;

    /**
     * @Description: json获取多个对象
     * @Param: int, int
     * @return: List<Phone>
     * @Author: hejie
     * @date: 2019/5/6
     */
    @GetMapping("/phoneJson")
    public List<Phone> phoneMulti(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "3") int size) {

        PageHelper.startPage(start, size, "id desc");
        List<Phone> list = phoneMapper.findAll();
        PageInfo<Phone> pageInfo = new PageInfo<>(list);
        return pageInfo.getList();
    }

    /**
     * @Description: json获取单个对象
     * @Param: int
     * @return: Phone
     * @Author: hejie
     * @date: 2019/5/6
     */
    @GetMapping("/phoneJson/{id}")
    public Phone phoneSingle(@PathVariable("id") int id) {

        Phone phone = phoneMapper.get(id);
        System.out.println(phone);
        return phone;
    }

    /**
     * @Description: json提交
     * @Param: Phone
     * @return:
     * @Author: hejie
     * @date: 2019/5/6
     */
    @PutMapping("/phoneJson")
    public void phoneSubmit(@RequestBody Phone phone) {

        System.out.println("springboot接受到浏览器以JSON格式提交的数据：" + phone.toString());
    }

}
