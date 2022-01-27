package com.zyq.mvc.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName JspController
 * @Author MagicBOOK
 * @Date 2022-01-19 21:14
 * @Version 1.0
 */
@ComponentScan
@Controller
public class JspController {
    @RequestMapping("/success")
    public String success(){
        return "/success";
    }
}
