package com.psj.CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * @Author:PSJ
 * @Date:2020/4/25 0025
 * @Descrption:com.psj.CollectionTest
 * @Version:1.0
 */
/*
迭代器Iterator接口：仅用于遍历集合Collection,不用于Map
Tips:coll.iterator()每次生成新的迭代器对象(一次性的东西)
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add("aaa");
        coll.add(new Person("psj",22));
        coll.add(13);
        coll.add(new Date());

        Iterator iterator = coll.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println("************");
        while (iterator.hasNext()){
            //*next（）是先下移，再返回元素值
            System.out.println(iterator.next());
        }

//        //错误写法1:跳跃输出并且报错
//        while (iterator.next() != null){
//            System.out.println(iterator.next());
//        }

//        //错误写法2：每次都返回第一个元素，并且不会终止（coll.iterator()每次生成新的迭代器对象）
//        while (coll.iterator().hasNext()){
//            System.out.println(coll.iterator().next());
//        }
    }
}
