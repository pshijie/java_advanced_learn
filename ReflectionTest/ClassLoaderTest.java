package com.psj.ReflectionTest;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author:PSJ
 * @Date:2020/5/13 0013
 * @Descrption:com.psj.ReflectionTest
 * @Version:1.0
 */
public class ClassLoaderTest {
    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2(系统类加载器)

        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);//sun.misc.Launcher$ExtClassLoader@3f99bd52(扩展类加载器)

        //引导类加载器负责加载java的核心类库，无法加载自定义类的
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);//null,获取不到引导类加载器

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);//null,说明String是引导类加载器加载的

    }

    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
        //读取配置文件的方式1：
        //此时的文件默认在当前的module下，如果要读取src下的配置文件，写为src\\jdbc.properties
//        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
//        properties.load(fileInputStream);

        //读取配置文件的方式2:使用ClassLoader
        //配置文件默认识别为当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(inputStream);

        String user = properties.getProperty("user");
        System.out.println(user);
    }
}
