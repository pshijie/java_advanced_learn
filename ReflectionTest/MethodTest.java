package com.psj.ReflectionTest;

/**
 * @Author:PSJ
 * @Date:2020/5/13 0013
 * @Descrption:com.psj.ReflectionTest
 * @Version:1.0
 */

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法结构
 */
public class MethodTest {
    @Test
    public void test(){
        Class clazz = Student.class;
        //getMethods()：获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods){
            System.out.println(m);
        }
        System.out.println("****************");
        //getDeclaredMethods()：获取当前运行时类中声明的所有方法（不包含父类的）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods){
            System.out.println(m);
        }
    }

    @Test
    public void test2() {
        Class clazz = Student.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods){
            //1.获取方法声明的注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations){
                System.out.println(a);
            }

            //2.权限修饰符
            System.out.println(Modifier.toString(m.getModifiers()) + "\t");

            //3.返回值类型
            System.out.println(m.getReturnType().getName() + "\t");

            //4.方法名
            System.out.println(m.getName() + "\t");

            //5.形参列表
            System.out.println("(");
            Class[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)){
                for (Class p : parameterTypes){
                    System.out.println(p.getName());
                }
            }
            System.out.println(")");

            //6.抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
        }
    }

}
