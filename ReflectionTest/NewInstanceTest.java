package com.psj.ReflectionTest;

/**
 * @Author:PSJ
 * @Date:2020/5/13 0013
 * @Descrption:com.psj.ReflectionTest
 * @Version:1.0
 */

import com.sun.org.apache.bcel.internal.classfile.ClassParser;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.junit.Test;

import java.io.ObjectOutputStream;
import java.util.Random;

/**
 * 通过反射创建对应的运行时类的对象
 * Tips:创建类的对象的方法如下：
 * 1.new + 构造器
 * 2.考虑Xxx,Xxxs,XxxFactory,XxxBuilder类中查看是否有静态方法的存在，调用该静态方法
 * 3.通过反射
 */
public class NewInstanceTest {

    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        Class clazz = Person.class;
        /**
         * newInstance()：内部调用了运行时类的空参构造器
         * 要求：1.类一定要有空参构造器
         *      2.空参构造器的访问权限通常设置为pubic
         *
         * 在javabean中要求提供一个public的空参构造器，原因：
         * 1.便于通过反射，创建运行时类的对象
         * 2.便于子类继承此运行时类时，默认调用super（）时，保证父类有此构造器
         */
        Person person = (Person) clazz.newInstance();
        System.out.println(person);
    }

    @Test
    public void test2(){//体现反射的动态性
        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "com.psj.ReflectionTest.Person";
                break;
        }

        try {
            Object instance = getInstance(classPath);
            System.out.println(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getInstance(String classPath) throws Exception {//创建一个指定类的对象
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
