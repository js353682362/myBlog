package com.jiaos.dingyue;

import org.junit.Test;

/**
 * @（#）:DYTest.java
 * @description:
 * @author: jiaosen 2017/10/25
 * @version: Version 1.0
 */
public class DYTest {
    @Test
    public void testDingYue(){
        //假设四个读者，两个作者
        Reader xieGK = new Reader("谢广坤");
        Reader zhaoS = new Reader("赵四");
        Reader qiG = new Reader("七哥");
        Reader liuN = new Reader("刘能");
        Writer xieDajiao = new Writer("谢大脚");
        Writer wangXM = new Writer("王小蒙");
        //四人关注了谢大脚
        xieGK.subscribe("谢大脚");
        zhaoS.subscribe("谢大脚");
        qiG.subscribe("谢大脚");
        liuN.subscribe("谢大脚");
        //七哥和刘能还关注了王小蒙
        qiG.subscribe("王小蒙");
        liuN.subscribe("王小蒙");

        //作者发布新书就会通知关注的读者
        //谢大脚写了设计模式
        xieDajiao.addNovel("设计模式");
        //王小蒙写了JAVA编程思想
        wangXM.addNovel("JAVA编程思想");
        //谢广坤取消关注谢大脚
        xieGK.unsubscribe("谢大脚");
        //谢大脚再写书将不会通知谢广坤
        xieDajiao.addNovel("观察者模式");
    }
}
