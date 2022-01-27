package com.zyq.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName TestController
 * @Author MagicBOOK
 * @Date 2022-01-13 20:17
 * @Version 1.0
 */
@Controller
public class TestController {
//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }
    @RequestMapping("/test_view")
    public String testView(){
        return "test_view";
    }
}
