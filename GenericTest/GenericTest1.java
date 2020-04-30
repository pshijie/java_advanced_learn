package com.psj.GenericTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:PSJ
 * @Date:2020/4/29 0029
 * @Descrption:com.psj.GenericTest
 * @Version:1.0
 */
public class GenericTest1 {
    @Test
    public void test1(){
        //不指定T的类型时默认object类型
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("aaa");

        //定义了泛型尽量使用
        Order<String> order1 = new Order<>("psj",22,"a");
        order1.setOrderT("66");

    }

    //子类继承了带有指明的泛型的父类后，使用的是父类的泛型
    @Test
    public void test2(){
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT(1);

        SubOrder1<Integer> subOrder1 = new SubOrder1<Integer>();
    }

    //泛型不同的引用不能直接赋值
    @Test
    public void test3(){
        ArrayList<Integer> list1 = null;
        ArrayList<String> list2 = null;
//        list1 = list2;//报错
    }

    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] integers = {1, 2, 3};
        //放进去是Integer类型就返回Integer
        List<Integer> copy = order.copyFromArrayToList(integers);
        System.out.println(copy);

    }

    @Test
    public void test5(){//泛型继承关系
        Object o1 = null;
        String o2 = null;
        o1 = o2;//不会报错

//        List<Object> l1 = null;
//        List<String> l2 = null;
//        l1 = l2;//报错，此时的list1和list2不具有子父类关系

        List<String> l1 = null;
        ArrayList<String> l2 = null;
        l1 = l2;//没得问题
    }

    @Test
    public void test6(){//通配符的使用
        List<Object> l1 = null;
        List<String> l2 = null;
        List<?> list = null;
        list = l1;
        list = l2;

        List<String> l3 = new ArrayList<>();
        l3.add("AA");
        l3.add("BB");
        l3.add("CC");
        list = l3;//不会报错
        //写入报错，对于List<?>不能向内部添加数据（除了加null）
//        list.add("aa");

        //获取：允许读取数据，读取的数据类型为object
        Object o = list.get(0);
        System.out.println(o);//AA
    }

    @Test
    public void test7() {   //Student是Person的子类
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> l3 = null;
        List<Person> l4 = null;
        List<Object> l5 = null;

//        list1 = l3;//没问题
//        list1 = l4;//没问题
//        list1 = l5;//报错

//        list2 = l3;//报错
//        list2 = l4;//没问题
//        list2 = l5;//没问题

        //读取数据时要注意返回的对象要符合范围
        list1 = l4;
        Person P = list1.get(0);//没问题
//        Student P = list1.get(0);//报错

        list2 = l4;
        Object obj = list2.get(0);//没问题
//        Person p1 = list2.get(0);//报错

        //写入数据：
//        list1.add(new Student());//报错
        list2.add(new Person());//没问题
        list2.add(new Student());//没问题，相当于把Student添加到Person中，符合多态
    }
}
