package com.zyq.mvc.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @date 2022-01-08
 */
@Controller
public class TestController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    /*
        ant风格路径中：
        ?表示单个字符
        *表示0或多个字符
        **表示任意的一层或多层目录
    */
//   可以访问http://localhost:8088/springMVC/ava/a/a/a/a/testAnt
    @RequestMapping(
            value = "/**/testAnt",
            params = {"username"}
    )
    public String testAnt(HttpServletRequest request){
        String username = request.getParameter("username");
        System.out.println(username);
        return "testAnt";
    }
//    restful风格,在路径中必须要有id参数和username
    @RequestMapping("/testpath/{id}/{username}")
    public String testPath(@PathVariable("id")Integer id,@PathVariable("username")String username){
        System.out.println(id);
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/testServletAPI")
//    这个request表示当前请求
    public String param(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.setAttribute("dsjakhdsa", "djsakdnsasd");
        Cookie cookie = new Cookie("abccc", "cdeee");
        response.addCookie(cookie);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username="+username+",password="+password);

        return "test_param";
    }

    @RequestMapping("/testParam")
    public String testParam(
            @RequestParam(value = "user_name", required = false, defaultValue = "ffffhhjggjgjgj") String username,
            String password,
            String[] hobby){
        System.out.println("username:"+username+",passsword:"+password+",hobby:"+Arrays.asList(hobby));
        return "test_param";
    }

}
