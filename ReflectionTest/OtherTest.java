package com.psj.ReflectionTest;

/**
 * @Author:PSJ
 * @Date:2020/5/14 0014
 * @Descrption:com.psj.ReflectionTest
 * @Version:1.0
 */

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class OtherTest {
    /**
     * 获取构造器结构
     */
    @Test
    public void test(){
        Class clazz = Student.class;
        //getConstructors():当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors){
            System.out.println(c);
        }
        System.out.println("*****************");
        //getDeclaredConstructors()：获取当前运行时类中声明的所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : declaredConstructors){
            System.out.println(c);
        }
    }

    /**
     * 获取父运行时类的父类的泛型
     */
    @Test
    public void test2(){
        Class clazz = Student.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
    }

    /**
     * 获取运行时类的父类实现的接口(动态代理时会使用到)
     */
    @Test
    public void test3(){
        Class clazz = Student.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces){
            System.out.println(c);
        }
    }
}
