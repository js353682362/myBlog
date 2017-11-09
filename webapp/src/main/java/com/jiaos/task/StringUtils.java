package com.jiaos.task;

import java.net.URL;

/**
 * @（#）:StringUtils.java
 * @description:
 * @author: jiaosen 2017/11/9
 * @version: Version 1.0
 */
public class StringUtils {

    /**
     * "file:/home/whf/cn/fh" -> "/home/whf/cn/fh"
     * "jar:file:/home/whf/foo.jar!cn/fh" -> "/home/whf/foo.jar"
     */
    public static String getRootPath(URL url){
        String fileUrl = url.getFile();

        int pos = fileUrl.indexOf('!');

        if(-1 == pos){
            return fileUrl;
        }
        return fileUrl.substring(5,pos);
    }

    /**
     * "cn.fh.lightning" -> "cn/fh/lightning"
     * @param name
     * @return
     */
    public static String doTopSplash(String name){
        return name.replaceAll("\\.","/");
    }

    /**
     * "Apple.class" -> "Apple"
     */
    public static String trimExtention(String name){
        int pos = name.indexOf('.');
        if(-1 != pos){
            return name.substring(0,pos);
        }
        return name;
    }

    /**
     * /application/home -> /home
     * @param uri
     * @return
     */
    public static String trimURI(String uri){
        String trimmed = uri.substring(1);
        int splashIndex = trimmed.indexOf('/');
        return trimmed.substring(splashIndex);
    }


}
