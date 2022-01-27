package com.zyq.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName TestController
 * @Author MagicBOOK
 * @Date 2022-01-23 22:12
 * @Version 1.0
 */
@Controller
public class TestController {
    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        return "success";
    }
    @RequestMapping("/testExceptionHandler")
    public String testException(){
        System.out.println(1 / 0);
        return "success";
    }
}
