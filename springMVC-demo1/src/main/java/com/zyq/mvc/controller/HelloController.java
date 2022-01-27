package com.zyq.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author admin
 * @date 2022-01-08
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/")
    public String index(){
//        返回视图名称
        return "index";
    }
    @RequestMapping(value = "/target")
    public String target(){
        return "target";
    }
}
