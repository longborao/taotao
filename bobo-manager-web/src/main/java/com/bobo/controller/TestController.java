package com.bobo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by robot on 2016/11/17.
 */
@Controller
public class TestController{
    @RequestMapping("/helloworld")
    public String getIndex(){
        return "index";
    }
    @RequestMapping("/hello")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv=new ModelAndView();
        //设置页面回显数据
        mv.addObject("index","饶龙博");
        mv.setViewName("login");
        return mv;
    }
}
