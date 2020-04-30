package com.psj.utilsTest;

import org.junit.Test;

import java.util.Date;

/**
 * @Author:PSJ
 * @Date:2020/4/22 0022
 * @Descrption:com.psj.utilsTest
 * @Version:1.0
 */
public class DateTimeTest {
    @Test
    public void Test1(){
        //util包中的date类型
        Date date1 = new Date();
        System.out.println(date1);//Wed Apr 22 22:21:48 CST 2020
        System.out.println(date1.getTime());

        Date d2 = new Date(1587565157947L);
        System.out.println(d2);

        //数据库中的date类型
        java.sql.Date d3 = new java.sql.Date(1587565157947L);
        System.out.println(d3);//2020-04-22

        //将util下的date转换为sql下的date
        Date d4 = new Date();
        java.sql.Date d5 = new java.sql.Date(d4.getTime());
        System.out.println(d5);
        //将sql下的date转换为util下的date(直接多态就行，sql下的是util下的子类)
        java.sql.Date date6 = new java.sql.Date(1587565157947L);
        java.util.Date date7 = date6;
        System.out.println(date7);
    }
}
