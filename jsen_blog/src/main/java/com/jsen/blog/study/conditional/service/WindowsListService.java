package com.jsen.blog.study.conditional.service;

import com.jsen.blog.study.conditional.interfacess.ListService;

/**
 * @（#）:WindowsListService.java
 * @description:
 * @author: jiaosen 2017/12/19
 * @version: Version 1.0
 */
public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
