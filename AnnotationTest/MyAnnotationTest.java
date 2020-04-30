package com.psj.AnnotationTest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;



/**
 * @Author:PSJ
 * @Date:2020/4/24 0024
 * @Descrption:com.psj.AnnotationTest
 * @Version:1.0
 */

/*
注解作用：可以在编译，类加载，运行时被读取
可以在不修改源文件的情况下补充源文件的信息

元注解：对注解的注解
4个元注解：
1*.@Retention:指定所修饰的注解的生命周期：
    SOURCE（不会保留在class文件中），
    CLASS（默认，保留在class文件中，但是不会加载到内存中），
    RUNTIME（会被加载到vm中，只有声明为RUNTIME才能通过反射获取）

2*.@Target:用于声明注解能修饰哪些程序元素
3.@Documented:指定被该注解修饰的类被javaDoc工具提取成文档（定义了该注解时，Retention必须设置为RUNTIME）
4.@Inherited:被它修饰的注解将具有继承性（person类上加了自定义注解，并且该自定义注解被该元注解修饰了，则子类student也会有自定义注解）
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotationTest {
    //这个value不是方法，是变量，表示可以定义的成员变量
    String[] value() default "demo";
}
