package com.psj.MapTest;

import org.junit.Test;

import java.util.*;

/**
 * @Author:PSJ
 * @Date:2020/4/28 0028
 * @Descrption:com.psj.MapTest
 * @Version:1.0
 */
/*
方法的测试
Tips:Map不同于Collection,没有迭代器
 */
public class MapTest2 {
    @Test
    public void test1(){
        HashMap map = new HashMap();
        map.put(1,"psj");
        map.put("a","psj1");
        map.put(1,"psj2");
        System.out.println(map);//{1=psj2, a=psj1}

        HashMap map1 = new HashMap();
        map1.put("cc",11);
        map1.put("cb",11);
        map.putAll(map1);
        System.out.println(map);//{cc=11, 1=psj2, a=psj1, cb=11}

        map.clear();//不是map=null
//        map = null;//空指针异常
        System.out.println(map.size());//0，不是空指针异常
        System.out.println(map);
    }

    @Test
    public void test2(){//*遍历map
        HashMap map = new HashMap();
        map.put(1,"psj");
        map.put("a","psj1");
        map.put(3,"psj2");

        //遍历所有的key,因为key是存在set中，set是Collection，可以使用迭代器
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍历所有的value,因为value是存在Collection中，可以使用迭代器
        Collection values = map.values();
        for(Object o : values){
            System.out.println(o);
        }

        //遍历所有的key-value对,这里采用的是取出每一个entry
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Map.Entry entry = (Map.Entry) iterator1.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println(entry);
        }
    }
}
