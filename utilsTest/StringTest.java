package com.psj.utilsTest;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author:PSJ
 * @Date:2020/4/21 0021
 * @Descrption:com.psj.utilsTest
 * @Version:1.0
 */
public class StringTest {
    @Test
    public void Test1(){
        String s1 = "ab";
        s1 = "abc";
        String s2 = "abc";

        System.out.println(s1);
        System.out.println(s1==s2);

        String s3 = "123";
        String s4 = s3.replace('1','m');
        //不会再在有的string上修改，重新建一个
        System.out.println(s3);
        System.out.println(s4);
        String s5 = new String(s3);
        String s6 = new String("99");
        System.out.println(s5);
        System.out.println(s6);
    }
    @Test
    public void Test2(){//new与直接声明
        //s1,s4声明在方法区的常量池中(***加了final修饰的存在常量池中***)
        String s1 = "java";
        String s4 = "java";
        //s2,s3保存在堆空间中
        String s2 = new String("java");
        String s3 = new String("java");
        System.out.println(s1==s2);//false
        System.out.println(s3==s2);//false
        System.out.println(s1==s4);//true
        System.out.println("###################");

        Person person1 = new Person(22, "psj");
        Person person2 = new Person(22, "psj");
        //这里比较的是name在常量池中的地址值,为什么和new两个相同的string对象结果不一样？
        System.out.println(person1.getName()==person2.getName());//true
        System.out.println(person1.getName().equals(person2.getName()));//true
        //因为new出来后对象肯定在堆空间地址不一样，上面比较对象中的属性和直接比较对象是有区别的
        System.out.println(person1==person2);//false

        //String s = new String("a");创建了几个对象？两个对象，一个对应常量池，一个对应堆空间
    }
    @Test
    public void  Test3(){//拼接字符串
        String s1 = "java";
        String s2 = "had";
        String s3 = "javahad";
        String s4 = s1+"had";
        String s5 = "java"+"had";
        System.out.println(s3 == s4);//false，有变量参与的拼接都相当于new了一个对象在堆中
        System.out.println(s3 == s5);//true，常量与常量拼接存在常量池中

        String s6 = s4.intern();//调用该方法强制到常量池中去找,不是首先去堆中，再根据堆中的地址值去常量池找
        System.out.println(s3 == s6);//true,返回的值是使用常量池中的值
    }
    @Test
    public void Test4(){//api的使用
        String s1 = "abc";
        String s2 = "abb";
        System.out.println(s1.compareTo(s2));
        String s3 = "ac111";
        String s4 = s3.replaceAll("\\d{1,2}", "dd");//将其中一位或两位数字转换为dd
        System.out.println(s4);
    }
    @Test
    public void Test5(){//String与其他基本数据类型，包装类的转换，char型数组
        String s1 = "123";
        int num = Integer.parseInt(s1);//string->基本数据类型和包装类
        System.out.println(num);

        int num1 = 1234;
        String s2 = String.valueOf(num1);//基本数据类型和包装类->string
        String s3 = num + "";//或者这样
        System.out.println(s2);

        String s4 = "11111";
        char[] ch1 = s4.toCharArray();//string->char数组
        for (char c: ch1) {
            System.out.println(c);
        }

        char[] ch2 = {'a', 'b', 'c'};//char数组->string
        String s5 = new String(ch2);
        System.out.println(s5);
    }
    @Test
    public void Test6() throws UnsupportedEncodingException {//string与byte[]类型的数组
        System.out.println("编码：");
        String str1 = "123456杰";
        byte[] bytes = str1.getBytes();//使用默认字符编码集编码(这里是utf-8)
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbk");
        System.out.println(Arrays.toString(gbks));

        System.out.println("***********************");

        System.out.println("解码：");
        String str2 = new String(bytes);//使用默认字符编码集进行解码(这里是utf-8)
        System.out.println(str2);

        String str3 = new String(gbks);
        System.out.println(str3);//出现乱码，编码集和解码集不一样

        String str4 = new String(gbks,"gbk");
        System.out.println(str4);
    }
}
