package com.blog.webs.httpclient;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.context.annotation.Configuration;


/**
 * @（#）:MyBlogClient.java
 * @description:
 * @author: jiaosen 2017/7/5
 * @version: Version 1.0
 */
@Configuration
public class MyBlogClient {
//    private Logger logger = LoggerFactory.getLogger(MyBlogClient.class);

    private CloseableHttpClient httpClient;
}
