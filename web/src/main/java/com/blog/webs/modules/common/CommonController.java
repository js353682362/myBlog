package com.blog.webs.modules.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @（#）:CommonController.java
 * @description:
 * @author: jiaosen 2017/7/5
 * @version: Version 1.0
 */
@Controller
public class CommonController {

    private String postJsonRequest(HttpServletRequest request) {
        return null;
    }

    @RequestMapping(value = "/web/*/**/*", method = RequestMethod.POST, consumes = {
            "application/json" })
    public String do_post(HttpServletRequest request) {
        return postJsonRequest(request);
    }
}
