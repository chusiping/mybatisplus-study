package com.atguigu.mybatisplus.controller;
import com.atguigu.mybatisplus.pojo.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class thymeleafDemo {
    @RequestMapping("/login")
    public String login(){
        return "index";
    }
    @RequestMapping("/include")
    public String include(){
        return "inc_demo";
    }
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-data");
        modelAndView.addObject("myuser", user);
        return modelAndView;
    }
}
