package com.jiaos.invocation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @（#）:Tttttsss.java
 * @description:
 * @author: jiaosen 2017/11/1
 * @version: Version 1.0
 */
//需要设置@Retention(RetentionPolicy.RUNTIME)这个表示运行期注解，这样在反射的时候才能取到
@Retention(RetentionPolicy.RUNTIME)
public @interface Tttttsss {
}
