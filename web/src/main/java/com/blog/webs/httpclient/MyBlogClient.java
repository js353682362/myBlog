package com.blog.webs.httpclient;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @（#）:MyBlogClient.java
 * @description:
 * @author: jiaosen 2017/7/5
 * @version: Version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "myBlog.server.http")
public class MyBlogClient {
     private Logger logger = LoggerFactory.getLogger(MyBlogClient.class);

    private CloseableHttpClient httpClient;

    /**
     * 服务端地址
     */
    private String serverAddressUrl;

    /**
     * 是否是安全的
     */
    private boolean ssl = false;

    /**
     * 密钥库文件路径
     */
    private String keystoreFilePath;

    /**
     * 密钥库密码
     */
    private String keystorePassWd;

    /**
     * 服务端地址
     */
    private String serverAddress;
    /**
     * 端口
     */
    private String serverPort;

    /**
     * 使用协议
     */
    private String[] sslProtocol = new String[] { "TLSv1.2", "SSLv3" };

    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String getServerAddressUrl() {
        return serverAddressUrl;
    }

    public void setServerAddressUrl(String serverAddressUrl) {
        this.serverAddressUrl = serverAddressUrl;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }

    public String getKeystoreFilePath() {
        return keystoreFilePath;
    }

    public void setKeystoreFilePath(String keystoreFilePath) {
        this.keystoreFilePath = keystoreFilePath;
    }

    public String getKeystorePassWd() {
        return keystorePassWd;
    }

    public void setKeystorePassWd(String keystorePassWd) {
        this.keystorePassWd = keystorePassWd;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public String[] getSslProtocol() {
        return sslProtocol;
    }

    public void setSslProtocol(String[] sslProtocol) {
        this.sslProtocol = sslProtocol;
    }

    public void init() {
        httpClient = HttpClients.createDefault();
        serverAddressUrl = "http://" + getServerAddress() + ":" + getServerPort();
    }

    public String postRequest(HttpServletRequest request, String reqParam) {
        HttpPost httpPost = new HttpPost(
                serverAddressUrl + request.getServletPath() + "?" + request.getQueryString());
        httpPost.setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json"));
        HttpEntity httpEntity = new StringEntity(reqParam, Charset.forName("UTF-8"));
        httpPost.setEntity(httpEntity);
        if (request.getSession() != null) {
            httpPost.setHeader("Cookie", "JSESSIONID=" + request.getSession().getId());
        } else {
            logger.error("");
            throw new RuntimeException();
        }
        return execute(httpPost);
    }

    public String execute(HttpRequestBase httpRequest) {
        InputStream inputStream = null;
        String content = null;
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpRequest);
            inputStream = httpResponse.getEntity().getContent();
            content = StreamUtils.copyToString(inputStream, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {

                }
            }
        }
        if (StringUtils.isBlank(content)) {
            content = "无返回数据";
        }
        return content;
    }

}
