package com.zyq.mvc.controller;

import com.zyq.mvc.bean.Employee;
import com.zyq.mvc.dao.EmployeeDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName UserContriller
 * @Author MagicBOOK
 * @Date 2022-01-21 17:20
 * @Version 1.0
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "employee", method = RequestMethod.GET)
    public ModelAndView getAllEmployee(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("getEmployee");
        modelAndView.addObject("employees", employeeDao.getAll());
        return modelAndView;
    }
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        ModelMap modelMap = new ModelMap();
        return "redirect:/employee";
    }
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String deleteEmployee(Employee employee){
        employeeDao.save(employee);
        ModelMap modelMap = new ModelMap();
        return "redirect:/employee";
    }
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String updateEmployeeById(@PathVariable("id")Integer id, ModelMap modelMap){
        Employee employee = employeeDao.get(id);
        modelMap.addAttribute("employee", employee);
        return "/employee_update";
    }
    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployeeById1(Employee employee){
        employeeDao.save(employee);
        System.out.println(employee);
        return "redirect:/employee";
    }
}
