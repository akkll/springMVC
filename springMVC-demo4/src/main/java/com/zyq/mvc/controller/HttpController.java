package com.zyq.mvc.controller;

import com.zyq.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName UserController
 * @Author MagicBOOK
 * @Date 2022-01-22 15:38
 * @Version 1.0
 */
@Controller
public class HttpController {
    @RequestMapping(value = "testRequestBody", method = RequestMethod.POST)
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println(requestBody);
        return "success";
    }
    @RequestMapping(value = "testRequestEntity", method = RequestMethod.POST)
    public String testRequestEntity(RequestEntity<String> requestEntity){
        System.out.println("body="+requestEntity.getBody());
        System.out.println("headers="+requestEntity.getHeaders());
        return "success";
    }
    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello, response");
    }
    @RequestMapping("/testResponseBody")
//   如果不加下面这个注解，则返回的success作为视图名称被解析
//   加上这个注解后则作为响应体
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }
    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User(1001, "张三", "djskahd", 32, "男");
    }

    @RequestMapping(value = "/testAxios", method = RequestMethod.POST)
    @ResponseBody
    public String testResponseAjax(String username, String password){
        System.out.println("username=" + username + ", password=" + password);
        return "helli, axios";
    }



}
