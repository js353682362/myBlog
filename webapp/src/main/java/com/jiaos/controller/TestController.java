package com.jiaos.controller;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @（#）:TestController.java
 * @description:
 * @author: jiaosen 2017/11/3
 * @version: Version 1.0
 */
@Controller
public class TestController {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @RequestMapping(value = "/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("test");
        Long result = sqlSessionTemplate.selectOne("selectTest");
        modelAndView.getModel().put("aaa",result);
        return modelAndView;
    }
}
