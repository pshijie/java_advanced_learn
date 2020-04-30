package com.psj.CollectionTest;

import org.junit.Test;

import java.util.*;

/**
 * @Author:PSJ
 * @Date:2020/4/25 0025
 * @Descrption:com.psj.CollectionTest
 * @Version:1.0
 */
/*
1.集合和数组都是存储数据的（存储涉及的是内存层面的，不是持久化的存储）
2.集合有Collection接口和Map接口，Collection接口中分List和Set
    List中有ArrayList,LinkedList,Vector
    Set中有HashSet,LinkedHashSet,TreeSet
    Map中有HashMap,LinkedHashMap,TreeMap,HashTable,Properties

Tips:1.集合添加对象时，对象尽量重写equals方法
 */
public class CollectionTest {
    @Test
    public void Test1(){
        Collection coll = new ArrayList();
        coll.add("aaa");
        coll.add(new Person("psj",22));
        coll.add(13);
        coll.add(new Date());

        //addAll:可以将一个集合的所有元素加到另一个集合中
        Collection coll1 = new ArrayList();
        coll1.add("bbb");
        coll1.add("ccc");
        coll.addAll(coll1);
        System.out.println(coll);

        //contains：比较的是内容，但是如果Person类没有重写equals方法，
        //调用的是object类的equals(实际就是==，比较地址，两个new的对象地址不同)
        System.out.println(coll.contains(new Person("psj",22)));

        //containsAll：判断coll是否包含coll2
        Collection coll2 = Arrays.asList("aaa","ccb");
        System.out.println(coll.containsAll(coll2));

        //remove:在移除时也要进行比较，所以也要重写equals方法
        //removeAll:从当前集合中移除coll3中的所有元素
        Collection coll3 = Arrays.asList("aaa",13);
        coll.removeAll(coll3);
        System.out.println(coll);

        //retainAll:求集合的交集，返回给当前集合
        //集合->数组：toArray
        //数组->集合：Arrays.asList(...)
        List list1 = Arrays.asList(new int[]{123, 456});
        System.out.println(list1);//[[I@2957fcb0],有问题，将这两个数看出一个对象
        List list2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(list2);//[123, 456]
    }

}
