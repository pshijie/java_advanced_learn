package com.psj.utilsTest;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author:PSJ
 * @Date:2020/4/23 0023
 * @Descrption:com.psj.utilsTest
 * @Version:1.0
 */
    /*
    java中的对象，正常情况下只能进行==和！=，不能使用>和<.要比较对象的大小就要使用Comparable
    String等包装类实现了Comparable接口，重写了compareTo方法
     */
public class CompareTest {
    @Test
    public void Test1(){
        String[] arr = {"aa", "cc", "mm","bb"};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void Test2(){//对于自定义类，需要排序就要自定义实现comparable接口
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("lenovo",34);
        goods[1] = new Goods("dell",50);
        goods[2] = new Goods("huawei",11);
        goods[3] = new Goods("llieas",11);
        //没实现compareTo方法前是没有用的
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }

    /*
    当元素的类型没有实现Comparable接口并且不好修改代码，考虑Comparator的对象进行排序（进行临时性的比较）
    这里的形式不是对象.compareTo(比较的对象)，而是参数中有两个比较的对象
     */
    @Test
    public void Test3(){
        String[] arr = {"aa", "cc", "mm","bb"};
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
//                return 0;
                throw new RuntimeException("类型错误");
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
