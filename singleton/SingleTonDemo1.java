package com.psj.singleton;

/**
 * @Author:PSJ
 * @Date:2020/3/23 0023
 * @Descrption:com.psj.singleton
 * @Version:1.0
 */

//饿汉模式
public class SingleTonDemo1 {
//    1.构造器私有化
    private SingleTonDemo1(){}

//    2.类初始化时就立即加载该对象
    private static SingleTonDemo1 instance = new SingleTonDemo1();

//    3.提供获取该对象的方法，没有synchroniz，效率高
    public static SingleTonDemo1 getInstance(){
        return instance;
    }

}

class SingleTonDemo1Test{
    public static void main(String[] args) {
        //    new SingleTonDemo1()会出错
        SingleTonDemo1 instance = SingleTonDemo1.getInstance();
        SingleTonDemo1 instance1 = SingleTonDemo1.getInstance();
        System.out.println(instance == instance1);
    }

}

