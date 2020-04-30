package com.psj.GenericTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:PSJ
 * @Date:2020/4/29 0029
 * @Descrption:com.psj.GenericTest
 * @Version:1.0
 */
public class Order<T> {
    String orderName;
    int orderId;

    /**
    类的内部就可以使用类的泛型
     */
    T orderT;

    public Order(){

    }

    //不是使用了泛型就是泛型方法
    public Order(String orderName, int orderId, T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public T getOrderT(){
        return orderT;
    }
    public void setOrderT(T orderT){
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    //静态方法不能使用泛型
//    public static void show(T orderT){
//        System.out.println(orderT);//报错
//    }

    //如果不在public前面加上<E>,编译器可能会认为E是某一个类，不是泛型（这个E与类中的T不一样）
    public <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E>  list = new ArrayList<>();
        for (E e : arr){
            list.add(e);
        }
        return list;
    }
    //调用在GenericTest1的test4方法


}
