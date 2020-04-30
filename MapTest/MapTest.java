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
    Map（key是无序的，不能重复，相当于用set存储。value是无序的，有重复的值，使用collection储存。
        每一个key-value键值对存储在EntrySet中）:
        Tips:key所属的类要重写equals()方法和hashCode()方法（set的特点），以HashMap为例。
             value所属的类要重写equals即可（它不是set储存的）

        -HashMap:线程不安全，效率高,存储null的key和value
            -LinkedHashMap:保证遍历map元素时按添加的顺序遍历
                        （原因：在原有的HashMap底层上，添加了一对指针，指向前一个和后一个元素）
        -TreeMap:保证按照添加的key-value对进行排序，实现排序遍历（按照key的自然排序或定制排序）
                底层使用红黑树
        -HashTable:线程安全，效率低,不能存储null的key和value
            -Properties:用来处理配置文件，key和value都是String类型

    *HashMap底层实现：jdk7及之前:数组+链表
                    jdk8:数组+链表+红黑树
    HashMap map = new HashMap();map.put(...,...);
    jdk7:
     1.底层创建了长度为16的一维数组Entry[] table
     2.经过多次的put操作后，然后调用每一个key所在类的hashCode()方法计算key的hash值，得出存放在Entry数组中的位置
     3.如果该位置为空，就添加成功。如果不为空，比较当前的key与已经存在的一个或多个数据的hash值
        如果该hash值与已存在的都不一样，该键值对添加成功（链表形式存储）
        如果该hash值与已存在的其中一个一样，继续比较：调用该key所在类的equals方法
            如果equals方法返回false：该键值对添加成功（链表形式存储）
            如果equals方法返回true：使用该key对应的value去*替换*相同key的value值
     默认扩容方式：扩容为原来的2倍，并将原来的数据复制过来(到临界值12，且要存放的位置非空，就开始扩容，不是等16再扩)

     Tips:1.临界值是16*0.75=12，0.75是默认加载因子
          2.使用加载因子（提前扩容）是为了让链表尽量的少，因为可能有很多元素都在一条链表上，产生多条链表

     jdk8:
     1.底层没有创建一个长度为16的数组
     2.首次调用put()方法时才去创建长度为16的数组，且底层的数组为Node[]，不是Entry[]
     3.当某一个位置的链表的数据个数>8，并且数组长度>64时(毕竟树型结构较复杂，能不建就不建)，此时这一条链表上的数据改为红黑树存储（方便查找）

     Tips:Node和Entry都是hash,key,value,next的结构,LinkedHashMap的Entry还有before和after
 */
public class MapTest {
    @Test
    public void test1(){
        Map map = new HashMap();
        map.put(null,1);
        map.put(null,null);

//        Hashtable table = new Hashtable();
//        table.put(null,null);//报错
//        table.put(null,1);//报错

    }
    @Test
    public void test2(){
        HashMap hashMap = new LinkedHashMap();
        hashMap.put(1,"psj");
        hashMap.put(2,"psj");
        hashMap.put(0,"psj1");
        System.out.println(hashMap);//按照添加的顺序
    }

}
