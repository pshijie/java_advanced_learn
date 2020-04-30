package com.psj.CollectionTest;

import com.sun.org.apache.bcel.internal.generic.ALOAD;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author:PSJ
 * @Date:2020/4/27 0027
 * @Descrption:com.psj.CollectionTest
 * @Version:1.0
 */
public class SetExer {
    //问题1：在List中删除重复数字值，尽量简单
    //方法：使用set将list中的数据存储（达到去重的效果），再将set转换为list返回
    public static List duplicateList(List list){
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }

    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(3));
        List list1 = duplicateList(list);
        for (Object integer : list1){
            System.out.println(integer);
        }
    }

    //前提：重写了hashCode方法和equals方法
    @Test
    public void test2(){
        HashSet set = new HashSet();
        Person p1 = new Person("psj", 22);
        Person p2 = new Person("psj2", 32);
        set.add(p1);
        set.add(p2);
        System.out.println(set);//[Person{name='psj', age=22}, Person{name='psj2', age=32}]

        p1.setName("cc");
        //remove调用时也要判断hash值（！！！），因为上面改了数据 ，改完后的p1的hash与之前的就不一样了，
        // 所以删除时找到该hash值对应位置并不是实际p1存储的位置，p1就没被删除
        set.remove(p1);
        System.out.println(set);//[Person{name='cc', age=22}, Person{name='psj2', age=32}]

        set.add(new Person("cc",22));
        System.out.println(set);//有三个对象，解析如下：
        //假设原来p1的hash值为100，它储存到100的位置上，但后面改了数据后它的hash值变成了200，但是位置没变（！！！）
        //此时新增一个一样的对象，hash值也是200，但是在hash值为200的位置上是没有对象的，所以可以添加进去

        set.add(new Person("psj",22));
        System.out.println(set);//四个对象，解析如下：
        //尽管现在储存的对象与原始的p1一样，意味hash值一样，但是后续要调用equals方法比较，
        //所以可以添加进去，和原始的p1在一个链表上（类比HashMap）
    }
}
