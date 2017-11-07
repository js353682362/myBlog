package com.blog.webs.modules.common;

import com.blog.webs.httpclient.MyBlogClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * @（#）:CommonController.java
 * @description:
 * @author: jiaosen 2017/7/5
 * @version: Version 1.0
 */
@Controller
public class CommonController {

    @Autowired
    private MyBlogClient myBlogClient;

    @RequestMapping(value = "/")
    public String root() {
        return "index";
    }

    @RequestMapping(value = "/auth/login")
    public String login() {
        return "/auth/login";
    }

    @RequestMapping(value = "/test")
    public String test() {
        return "test";
    }

    /**
     * 跳转界面
     *
     * @param toPage
     * @return
     */
    @RequestMapping(value = "/toPage", method = RequestMethod.GET)
    public String toPage(@RequestParam("toPage") String toPage) {
        return toPage;
    }

    private String postJsonRequest(HttpServletRequest request) {
        return myBlogClient.postRequest(request, makeRequestObject(request));
    }

    public String makeRequestObject(ServletRequest request) {
        int contentLength = request.getContentLength();
        byte buffer[] = new byte[contentLength];
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            for (int i = 0; i < contentLength;) {
                int readLength = inputStream.read(buffer, i, contentLength - i);
                if (readLength == -1) {
                    break;
                }
                i += readLength;
            }
        } catch (IOException e) {
            throw new RuntimeException();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        }
        String charEncoding = request.getCharacterEncoding();
        if (StringUtils.isBlank(charEncoding)) {
            charEncoding = "UTF-8";
        }
        try {
            return new String(buffer, charEncoding);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException();
        }
    }

    @RequestMapping(value = "/web/*/**/*", method = RequestMethod.POST, consumes = {
            "application/json" })
    public String do_post(HttpServletRequest request) {
        return postJsonRequest(request);
    }

    @RequestMapping(value = "/web/*/**/*", method = RequestMethod.GET)
    public String do_get(HttpServletRequest request) {
        return null;
    }

}
