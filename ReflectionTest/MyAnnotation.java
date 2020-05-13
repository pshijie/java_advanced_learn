package com.psj.ReflectionTest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author:PSJ
 * @Date:2020/5/13 0013
 * @Descrption:com.psj.ReflectionTest
 * @Version:1.0
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "hello";
}
