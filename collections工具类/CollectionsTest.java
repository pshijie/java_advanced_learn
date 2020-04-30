package com.psj.collections工具类;

import org.junit.Test;

import java.util.*;

/**
 * @Author:PSJ
 * @Date:2020/4/28 0028
 * @Descrption:com.psj.Collections工具类
 * @Version:1.0
 */
/**
Collections:操作collection（接口）和Map（接口）的工具类
 **/
public class CollectionsTest {
    @Test
    public void test(){//huhuhu

        List list = new ArrayList();
        list.add (1);
        list.add(1);
        list.add(3);
        list.add(4);
        System.out.println(list);//[1, 2, 3, 4]

//        Collections.reverse(list);
//        System.out.println(list);//[4, 3, 2, 1]

//        Collections.shuffle(list);//随机
//        System.out.println(list);

//        Collections.swap(list,2,3);
//        System.out.println(list);

//        int frequency = Collections.frequency(list, 1);//1元素出现的频率
//        System.out.println(frequency);

//        List list1 = new ArrayList(10);
//        System.out.println(list1.size());//0，这里是填充了几个元素，不是声明的数组大小

//        List list1 = new ArrayList();
//        Collections.copy(list1,list);//报异常，因为此时list1的size值是0，需要大于等于list的size值

//        List list1 = Arrays.asList(new Object[list.size()]);//*将list1的size扩大
//        System.out.println(list1.size());//4
//        Collections.copy(list1,list);
//        System.out.println(list1);

//        List list1 = Collections.synchronizedList(list);//将线程不安全的list转换为线程安全的


    }
}
