package com.zyq.mvc.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName UserController
 * @Author MagicBOOK
 * @Date 2022-01-20 12:51
 * @Version 1.0
 */
@Controller
public class UserController {
    /*
    使用 RESTful模拟用户资源的增删改查
    /user       get     查询所有用户信息
    /user/1       get     根据用户id查询用户信息
    /user       post     添加所有用户信息
    /user/1       delete     删除用户信息
    /user       put     更新用户信息
    */
    @RequestMapping(
            value = "/user",
            method = RequestMethod.GET
    )
    public String getAllUsers(){
        System.out.println("查询所有用户信息");
        return "success";
    }
    @RequestMapping(
            value = "/user/{id}",
            method = RequestMethod.GET
    )
    public String getUsersById(@PathVariable(value = "id") Integer id){
        System.out.println("查询id为"+id  +"的用户信息");
        return "success";
    }
    @RequestMapping(
            value = "/user",
            method = RequestMethod.POST
    )
    public String posyUser(String username, String password){
        System.out.println(username+":"+password);
        return "success";
    }
    @RequestMapping(
            value = "/user",
            method = RequestMethod.PUT
    )
    public String putUser(String username, String password){
        System.out.println("使用put请求方法");
        System.out.println(username+":"+password);
        return "success";
    }
    @RequestMapping(
            value = "/user/{id}",
            method = RequestMethod.DELETE
    )
    public String deleteUser(String username, String password, @PathVariable Integer id){
        System.out.println("使用delete请求方法, id为："+id);
        System.out.println(username);
        return "success";
    }


}
