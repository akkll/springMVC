package com.zyq.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName TestController
 * @Author MagicBOOK
 * @Date 2022-01-25 21:21
 * @Version 1.0
 */
@Controller
public class TestController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/haode")
    public String haode(){
        System.out.println(1 / 0);
        return "haode";
    }

}
