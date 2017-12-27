package com.jsen.blog.study.conditional.service;

import com.jsen.blog.study.conditional.interfacess.ListService;
import org.springframework.stereotype.Service;

/**
 * @（#）:LinuxListService.java
 * @description:
 * @author: jiaosen 2017/12/19
 * @version: Version 1.0
 */
public class LinuxListService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
