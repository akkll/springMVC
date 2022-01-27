package com.zyq.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ViewController
 * @Author MagicBOOK
 * @Date 2022-01-15 17:57
 * @Version 1.0
 */
@Controller
public class ViewController {
    @RequestMapping("testThymeleafView")
    public String testThymeleafView(){
        return "success";
    }
    @RequestMapping("testForward")
    public String testForward(){
        return "forward:/testThymeleafView";
    }
    @RequestMapping("testRedirect")
    public String testRedirect(){
        return "redirect:/testThymeleafView";
    }
    @RequestMapping("testRedirect2")
    public String testRedirect2(){
        return "redirect:/";
    }

}
