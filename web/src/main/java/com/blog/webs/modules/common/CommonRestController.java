package com.blog.webs.modules.common;

import com.blog.common.result.ResponseObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @（#）:CommonRestController.java
 * @description:
 * @author: jiaosen 2017/8/11
 * @version: Version 1.0
 */
@RestController
public class CommonRestController {


    @RequestMapping(value = "/webAuth/**/*",method = RequestMethod.POST)
    public ResponseObject ie_web_auth_post(HttpServletRequest request){
        return new ResponseObject();
    }
}
