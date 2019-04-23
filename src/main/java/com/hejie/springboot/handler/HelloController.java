package com.hejie.springboot.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

/**
  * @program: springboot
  * @description:
  * @author: hejie
  * @create: 2019/4/18
  */
@Controller
public class HelloController {

    /**
      * @Description:
      * @Param: Model
      * @return: String
      * @Author: hejie
      * @date: 2019/4/18
      */
    @RequestMapping("/hello")
    public String hello(Model model) throws Exception {

        if (true) {
            throw new Exception("some exception");
        }

        model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }
}
