package com.zyq.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ClassName ExceptionCnreoller
 * @Author MagicBOOK
 * @Date 2022-01-25 21:42
 * @Version 1.0
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = {Exception.class})
    public String exceptionHandler(Model model, Exception ex){
        model.addAttribute("ex", ex);
        return"error";
    }
}
