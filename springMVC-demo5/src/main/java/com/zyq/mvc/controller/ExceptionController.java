package com.zyq.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName ExceptionController
 * @Author MagicBOOK
 * @Date 2022-01-25 18:10
 * @Version 1.0
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class, IllegalStateException.class})
    public String arithmeticException(Exception ex){
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("ex", ex);
//        mv.setViewName("error");
        ModelMap mv = new ModelMap();
        mv.addAttribute("ex", ex);
        return "error";
    }
}
