package com.hejie.springboot.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
  * @program: springboot
  * @description: 异常捕获处理器类
  * @author: hejie
  * @create: 2019/4/18
  */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
      * @Description:
      * @Param: HttpServletRequest, Exception
      * @return: ModelAndView
      * @Author: hejie
      * @date: 2019/4/18
      */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName("error");
        return mav;

    }

}
