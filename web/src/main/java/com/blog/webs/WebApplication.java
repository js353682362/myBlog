package com.blog.webs;

import com.blog.webs.httpclient.MyBlogClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.blog.webs")
public class WebApplication {


	@Bean(initMethod = "init")
	public MyBlogClient myBlogClient() {
		return new MyBlogClient();
	}


	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}


}
