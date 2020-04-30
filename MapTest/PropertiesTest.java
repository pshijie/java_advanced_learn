package com.psj.MapTest;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author:PSJ
 * @Date:2020/4/28 0028
 * @Descrption:com.psj.MapTest
 * @Version:1.0
 */
/*
Properties:用来处理配置文件，key和value都是String类型
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = PropertiesTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(inputStream);//加载流对应的文件

        String name = properties.getProperty("name");
        String password = properties.getProperty("password");
        System.out.println(name);
        System.out.println(password);
    }
}
