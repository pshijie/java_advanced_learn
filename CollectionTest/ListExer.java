package com.psj.CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:PSJ
 * @Date:2020/4/26 0026
 * @Descrption:com.psj.CollectionTest
 * @Version:1.0
 */
public class ListExer {
    @Test
    public void testListRemove(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//1,2
    }

    public static void updateList(List list) {
        list.remove(2);//这里移除的是下标index下的，不是直接删除2这个数字
//        list.remove(new Integer(2));
    }


}
