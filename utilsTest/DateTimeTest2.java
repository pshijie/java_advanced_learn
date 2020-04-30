package com.psj.utilsTest;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Author:PSJ
 * @Date:2020/4/23 0023
 * @Descrption:com.psj.utilsTest
 * @Version:1.0
 */
public class DateTimeTest2 {
    /*
    SimpleDateFormat对日期Date类的格式化和解析
    1.格式化：日期->字符串
    2.解析：字符串->日期
     */
    @Test
    public void TestSimpleDateFormat() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(date);
        //格式化日期
        String format = sdf.format(date);
        System.out.println(format);

        //解析：字符串必须要符合格式
        String str = "20-4-23 下午8:03";
        Date date1 = sdf.parse(str);
        System.out.println(date1);
        System.out.println("**************************");

        //让其按指定格式格式化和解析
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = sdf1.format(date);
        System.out.println(format1);
        //解析：字符串必须要符合格式
        Date date2 = sdf1.parse("2020-04-23 08:08:05");
        System.out.println(date2);
    }

    /*
    将字符串"2020-04-23"转换为java.sql.Date
     */
    @Test
    public void  testExer() throws ParseException {
        String birth = "2020-04-23";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);
//        System.out.println(date);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }

    /*
    Calendar类的使用
     */
    @Test
    public void testCalendar(){
        //1.创建其子类的对象（因为Calendar是抽象类，不能直接new出来）
//        Calendar calendar = new GregorianCalendar();
        //2.调用其静态方法getInstance（还是调用其子类GregorianCalendar）
        Calendar calendar1 = Calendar.getInstance();
//        System.out.println(calendar1.getClass());
//        System.out.println(calendar1);

        int days = calendar1.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        calendar1.set(Calendar.DAY_OF_MONTH,1);
        int day2 = calendar1.get(Calendar.DAY_OF_MONTH);
        System.out.println(day2);
    }
}
