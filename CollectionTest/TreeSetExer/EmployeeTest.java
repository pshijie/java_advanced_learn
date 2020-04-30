package com.psj.CollectionTest.TreeSetExer;

import jdk.nashorn.internal.ir.IfNode;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Author:PSJ
 * @Date:2020/4/27 0027
 * @Descrption:com.psj.CollectionTest.TreeSetExer
 * @Version:1.0
 */
/*
Tips:按照指定的方法进行比较后，只要返回的是0（即相同），就不会插入到set中，即使这两个对象本质上不一样
 */
public class EmployeeTest {
    @Test
    //使用自然排序,按名字排序
    public void test1(){
        TreeSet set = new TreeSet();
        Employee e1 = new Employee("psj",22,new MyDate(1998,5,17));
        Employee e2 = new Employee("psj1",23,new MyDate(1997,5,17));
        Employee e3 = new Employee("psj2",24,new MyDate(1996,5,17));
        Employee e4 = new Employee("psj6",25,new MyDate(1995,5,17));
        Employee e5 = new Employee("psj4",26,new MyDate(1994,5,17));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    //使用自定义排序,按生日排序
    public void test2(){

        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee)o1;
                    Employee e2 = (Employee)o2;
                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();

                    int minusYear = b1.getYear() - b2.getYear();
                    if (minusYear != 0){
                        return minusYear;
                    }

                    int minusMonth = b1.getMonth()-b2.getMonth();
                    if (minusMonth != 0){
                        return minusMonth;
                    }
                   return b1.getDay()-b2.getDay();
                }
                throw new RuntimeException("传入的数据类型不一致");
            }
        });
        Employee e1 = new Employee("psj",22,new MyDate(1998,5,17));
        Employee e2 = new Employee("psj1",23,new MyDate(1997,5,17));
        Employee e3 = new Employee("psj2",24,new MyDate(1996,5,17));
        Employee e4 = new Employee("psj6",25,new MyDate(1990,5,17));
        Employee e5 = new Employee("psj4",26,new MyDate(1990,4,17));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
