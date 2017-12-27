package com.jsen.blog.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @（#）:AsciiCamerController.java
 * @description:
 * @author: jiaosen 2017/12/26
 * @version: Version 1.0
 */
@Controller
public class AsciiCameraController {

    @RequestMapping(value = "/asciiCamera", method = RequestMethod.GET)
    public String asciiCamera() {
        return "ascii";
    }
}
