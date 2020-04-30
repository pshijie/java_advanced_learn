package com.psj.CollectionTest;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author:PSJ
 * @Date:2020/4/26 0026
 * @Descrption:com.psj.CollectionTest
 * @Version:1.0
 */
/*
ArrayList,LinkedList,Vector的异同：
同：存储数据是有序的，可重复的
不同：ArrayList：线程不安全，底层使用object[]数组，扩容1.5倍
     Vector（较老）：线程安全，底层使用object[]数组，扩容两倍
     LinkedList: 底层使用双向链表存储

ArrayList源码分析：
    ArrayList list = new ArrayList();
    jdk7:
    底层创建了一个大小为10的数组（饿汉式），当容量不够时扩容为原来的1.5倍，同时将原数据复制到新的数组中
    Tips:建议使用带参构造器
    jdk8:
    底层没有一开始就创建长度为10的数组,添加元素后才创建了长度为10的数组（懒汉式）
    扩容操作与jdk7一样
 */
public class ListTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add("aaa");
        list.add("aaa");
        list.add(1,1);
        System.out.println(list);
        int i = list.indexOf(111);
        System.out.println(i);//-1
    }
}
