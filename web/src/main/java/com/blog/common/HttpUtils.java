package com.blog.common;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * @（#）:HttpUtils.java
 * @description:
 * @author: jiaosen 2017/8/10
 * @version: Version 1.0
 */
public class HttpUtils {

    public static String makeJsonRequest(ServletRequest request) {
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
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
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
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
