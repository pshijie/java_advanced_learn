package com.psj.ReflectionTest;

/**
 * @Author:PSJ
 * @Date:2020/5/13 0013
 * @Descrption:com.psj.ReflectionTest
 * @Version:1.0
 */

import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的所有属性结构
 */
public class FieldTest {
    @Test
    public void test(){
        Class clazz = Student.class;
        //获取属性结构
        //getFields()：获取当前运行时类及其父类中声明为public权限的属性
        Field[] fields = clazz.getFields();
        for (Field f : fields){
            System.out.println(f);
        }
        System.out.println("****************");
        //getDeclaredFields():获取当前运行时类的所有属性（不包含父类声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields){
            System.out.println(f);
        }
    }

    @Test
    public void test2() {
        Class clazz = Student.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields){
            //1.获取权限修饰符
            int modifiers = f.getModifiers();
            System.out.println(modifiers);//2 0 1
            System.out.println(Modifier.toString(modifiers) + "\t");//private " " public
            //2.数据类型
            Class type = f.getType();
            System.out.println(type.getName() + "\t");
            //3.变量名
            String name = f.getName();
            System.out.println(name);
        }
    }
}
