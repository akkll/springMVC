package com.zyq.mvc.controller;

import com.zyq.mvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName ScopeController
 * @Author MagicBOOK
 * @Date 2022-01-13 20:26
 * @Version 1.0
 */
@Controller
public class ScopeController {
    @RequestMapping("testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request){
        request.setAttribute("requestScope", "testRequestByServletAPI");
        return "success";
    }
    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("requestScope", "testModelAndView");
        mav.setViewName("success");
        return mav;
    }
    @RequestMapping("testModel")
    public String testModel(Model model){
        model.addAttribute("requestScope", "testModel");
        return "success";
    }
    @RequestMapping("testMap")
    public String testMap(Map<String, Object> map){
        map.put("requestScope", "testMap");
        return "success";
    }
    @RequestMapping("testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("requestScope", "testModelMap");
        return "success";
    }
    @RequestMapping("testSession")
    public String testSession(HttpSession httpSession){
        httpSession.setAttribute("requestScope", "testSession");
        return "success";
    }
    @RequestMapping("testApplication")
    public String application(HttpSession httpSession){
        ServletContext servletContext = httpSession.getServletContext();
        servletContext.setAttribute("applicationScope", "testApplication");
        return "success";
    }

}
