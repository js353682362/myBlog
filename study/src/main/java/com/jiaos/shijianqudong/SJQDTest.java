package com.jiaos.shijianqudong;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @（#）:SJQDTerst.java
 * @description:
 * @author: jiaosen 2017/10/25
 * @version: Version 1.0
 */
public class SJQDTest {
    @Test
    public void test(){
        Reader zhangsan = new Reader("张三");
        Reader lisi = new Reader("李四");
        Reader wangermazi = new Reader("王二麻子");

        Writer zhaowu = new Writer("赵五");
        Writer zhouliu = new Writer("周六");

        zhangsan.subscribe("赵五");
        lisi.subscribe("赵五");
        wangermazi.subscribe("赵五");
        zhangsan.subscribe("周六");
        lisi.subscribe("周六");
        wangermazi.subscribe("周六");

        zhaowu.addNovel("新书");
    }

    @Test
    public void testList(){
        List<String> testList = new ArrayList<>();
        Map<String,List<String>> testMap = new HashMap<>();

        testList.add("a");
        testList.add("b");
        testList.add("c");
        testList.add("d");
        testMap.put("aaa",testList);
        System.out.println(testMap.get("aaa"));
        List<String> testList2 = testMap.get("aaa");
        testList2.add("3");
        System.out.println(testMap.get("aaa"));
    }
}
