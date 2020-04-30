package com.psj.io;

/**
 * @Author:PSJ
 * @Date:2020/4/30 0030
 * @Descrption:com.psj.io
 * @Version:1.0
 */

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * File类的一个对象就代表了一个文件或者是一个文件夹，具体的写/读要涉及到IO流
 * Tips:1.关于路径分隔符，windows和DOS中默认使用"\"表示，UNIX和URL使用"/"表示，
 *      写了两个斜杠就是转义
 *      2.当new File("a.txt")后,如果a.txt不存在，是不会帮忙创建文件或文件夹
 *        这时a.txt只是内存层面上的东西，要使用create或mkdir等函数
 *
 */
public class FileTest {

    @Test
    public void test(){

        File file = new File("hello.txt");//路径相对于当前的module
//        File file1 = new File("D:"+File.separator+"java"+File.separator+"hello.txt");//通用写法
        System.out.println(file);

//        File file1 = new File("E:\\java","demo1");//表明在E:\java下创建demo1这个文件目录或文件

//        File file2 = new File(file1,"hello1.txt");//表示在file1这个文件目录下的hello.txt文件

    }

    @Test
    public void test1(){//文件部分信息获取
        File file = new File("hello.txt");
        System.out.println(file.getAbsolutePath());//E:\java-code-extra\redisDemo\demo1\hello.txt
        System.out.println(file.getPath());//hello.txt
        System.out.println(file.length());//8
        System.out.println(file.getParent());//null

        File file1 = new File("e:\\io\\hello1.txt");
        System.out.println(file1.getAbsolutePath());//e:\io\hello1.txt
        System.out.println(file1.getPath());//e:\io\hello1.txt
        System.out.println(file1.getParent());//e:\io
    }

    @Test
    public void test2() {//文件罗列
        File file = new File("e:\\gitSpace");
        String[] list = file.list();
        for (String s : list){
            System.out.println(s);//输出gitSpace下一层的文件的名称
        }

        File[] files = file.listFiles();
        for (File s : files){
            System.out.println(s.toString());//输出gitSpace下一层文件的完整路径
        }
    }

    @Test
    public void test3() {//文件属性的判断
        File file = new File("hello.txt");
        System.out.println(file.isDirectory());//false
        System.out.println(file.isFile());//true
        System.out.println(file.exists());//true
        System.out.println(file.canRead());//true
        System.out.println(file.canWrite());//true
        System.out.println(file.isHidden());//false
    }

    @Test
    public void test4() throws IOException {//在磁盘（不是内存）中对文件或文件目录的操作
        File file = new File("hello1.txt");
        if (!file.exists()){
            file.createNewFile();
            System.out.println("add success!");
        }else{
            file.delete();
            System.out.println("delete success!");
        }

//        File file1 = new File("e:\\gitSpace\\ioDemo");
//        System.out.println(file1.mkdir());//当需要创建的目录上一层目录不存在就不创建了
//        System.out.println(file1.mkdirs());//当需要创建的目录上一层目录不存在，帮忙创建上一层目录


    }
}

