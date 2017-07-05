package com.blog.zuul.filter;

import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;

import javax.servlet.http.HttpServletRequest;

/**
 * @（#）:MyBlogFilter.java
 * @description:
 * @author: jiaosen 2017/7/5
 * @version: Version 1.0
 */
@Component
public class MyBlogFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(MyBlogFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        final String servletPath = request.getServletPath();
        if(StringUtils.startsWith(servletPath,"/webs/")){
            return true;
        }else if(StringUtils.startsWith(servletPath,"/webAuth/")){
            return false;
        }
        throw new RuntimeException();
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        return null;
    }
}
