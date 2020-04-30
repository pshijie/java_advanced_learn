package com.psj.CollectionTest;

import org.junit.Test;

import java.util.*;

/**
 * @Author:PSJ
 * @Date:2020/4/26 0026
 * @Descrption:com.psj.CollectionTest
 * @Version:1.0
 */
/*
set：无序性：不是随机性，是在添加的时候不是按数组下标0,1,2..这样去放元素，
            而是按比如下标3,5,1...这样去放，但是第一个add的元素还是第一进入集合
    不可重复性：保证添加的元素按照equals方法判断时，不能返回true.
    （没有使用hash值比较前，用equals方法比较不同的对象时需要将被比较的对象与前面所有的对象进行依次比较）
    Tips:向Set添加元素时，所在类一定要重写hashCode()方法equals()方法
         原因：比如new了两个A，但是A没有重写hashCode()方法，new出来的hashCode肯定是不同的，所以两个A都会被添加进去

HashSet（链表+数组，七上八下，类比HashMap）:线程不安全，可以存储null值，HashSet中添加元素时，先调用hashCode()方法，计算出在底层数组的
的存放位置，判断是否有元素：
    如果没有，添加成功
    如果有另一个元素b，则和b的hash值进行比较：
        如果不相同，添加成功
        如果相同，进一步调用equals方法，true就添加失败

LinkedHashSet（HashSet的子类）:可以按照添加的顺序遍历（因为是双向链表连起来的），显示是添加的顺序显示，但还是具有无序性。

TreeSet（红黑树，要求对象可以排序）:可以按照添加的对象的指定属性进行排序,先TreeSet添加的数据，*要求是相同类的对象*，并且要重写compareTo方法，不再使用equals方法
可以使用自然排序（继承Compareable接口，实现compareTo方法）或定制排序（实现Comparator接口）
    Tips:没有写明排序方法直接进行add是会报错的
 */
public class SetTest {
    @Test
    public void test(){
        Set set = new HashSet();

        set.add(1);
        set.add(2);
        set.add("aa");
        set.add(new Person("psj",22));
        set.add(new Person("psj",22));//没有重写hashCode方法时，
                                                // 返回两个对象（调用的Object类的hashCode(),比较的是地址，返回不同的hash值）
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){//自然排序
        Set set = new TreeSet();
        //不能添加不同类的对象
//        set.add(1);
//        set.add(2);
//        set.add("aa");
//        set.add(new Person("psj",22));

        //没有重写compareTo方法时是会报错的
        set.add(new Person("psj",22));
        set.add(new Person("qsj",22));
        set.add(new Person("asj",22));
        //这个被认为是重复是因为TreeSet认为的相同是建立在compareTo方法上，看该方法的返回值是否相同，要实现完整的比较只能从该方法上入手
        set.add(new Person("asj",32));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3(){//定制排序
        Comparator comparator = new Comparator() {
            //按照年龄排序,并且当年龄相同时就认为是一样的对象
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(),p2.getAge());
                }else{
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };
        TreeSet set = new TreeSet(comparator);
        set.add(new Person("psj",22));
        set.add(new Person("qsj",21));
        set.add(new Person("esj",24));
        set.add(new Person("asj",24));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
