package com.psj.GenericTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author:PSJ
 * @Date:2020/4/18 0018
 * @Descrption:com.psj.GenericTest
 * @Version:1.0
 */

/**
 * 泛型的类型必须是类，不能是基本数据结构
 * 泛型的参数可以有多个<E,V,T...>
 * 泛型不同的引用不能直接赋值
 * 静态方法不能使用泛型,因为泛型是在实例化的时候确定，而静态方法在实例化前
 * 异常类不能是泛型类
 *
 * 泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数无关，泛型方法与所属的类是不是泛型无关
 * 不是使用了泛型就是泛型方法（见Order类）
 * 泛型方法可以声明为静态的。原因：泛型参数是在调用方法时确定的，不是在实例化确定的
 *
 * 泛型在继承方面的体现：
 * 类A是类B的父类，G<A>和G<B>二者不具有子父类的关系，二者是并列关系，所以不能直接赋值
 * 但是A<G>和B<G>是可以直接赋值的
 *
 * 通配符 ? 的使用：
 * 类A是类B的父类，G<A>和G<B>是没有关系的(并列)，二者共同的父类是：G<?>,意味着可以将G<A>/G<B>赋值给G<?>
 * 写入报错，比如对于List<?>不能向内部添加数据（除了写入null）
 * 获取不报错：允许读取数据，读取的数据类型为object（?的父类反正是object）
 *
 * 有限制条件的通配符的使用：(? extends/super ...)，具体见GenericTest1的test7
 * ? extends A : G<? extends A> 可以作为G<A>和 G<B>的父类，其中B是A的子类（视为小于等于）
 * ? super A : G<? super A> 可以作为G<A>和 G<B>的父类，其中B是A的父类（视为大于等于）
 *
 */
public class GenericTest {

    @Test
    public void test(){
        ArrayList list = new ArrayList();
        list.add(100);
        list.add(69);
        list.add(10);
//        list.add("aaa");

        for (Object score:list) {
            //string强转int会出现问题
            int s = (int) score;
            System.out.println(s);
        }
    }

    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(77);
        list.add(77);
//        for (Integer score:list) {
//            //string强转int会出现问题
//            int s = score;
//            System.out.println(s);
//        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int next = iterator.next();
            System.out.println(next);
        }
    }


}
