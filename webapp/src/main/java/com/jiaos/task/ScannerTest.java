package com.jiaos.task;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;

/**
 * @（#）:ScannerTest.java
 * @description:
 * @author: jiaosen 2017/11/10
 * @version: Version 1.0
 */
public class ScannerTest {
    private Logger logger = LoggerFactory.getLogger(ScannerTest.class);

    @Test
    public void testScanner() {
        String scannPackage = "com.jiaos";
        scannPackage = scannPackage.replaceAll("\\.", "/");
        // url：统一资源定位符，uri：同意资源标识符
        // URI：统一资源标识
        // URL：统一资源 定位
        // URN：统一资源名称
        //
        // 例如：www.baidu.com是URL 但不是URI
        // www.baidu.com/index.html 是URL 同时也是URI。
        // 好像不太对啊， 因为 www.baidu.com = www.baidu.com/index.html
        // 所以，URL 就是 URI 的 定位。
        //
        // 但URI 不一定是 URL。
        // 因为 URI有一类子集是 URN，它命名资源 但 不指定 如何定位资源。
        // 如： mailto, news等，需要 加上 相应的结构参数，才能进行 统一资源定位。
        // 如： mailto:aykimforward@qq.com
        //
        // 因此，三者之间的关系是：URI 一定是 URL
        // URN+结构参数 = URI 就是 URL。
        URL url = this.getClass().getClassLoader().getResource(scannPackage);
        logger.info(url.getFile());
        File file = new File(url.getFile());
    }
}
