package com.psj.singleton;

/**
 * @Author:PSJ
 * @Date:2020/3/23 0023
 * @Descrption:com.psj.singleton
 * @Version:1.0
 */

//懒汉式（用的时候再去加载）
public class SingleTonDemo2 {
    //    1.构造器私有化
    private SingleTonDemo2(){}
    //    2.类初始化时就，不立即加载该对象
    private static SingleTonDemo2 instance;

    //    3.提供获取该对象的方法，有synchroniz，效率低
    public static synchronized SingleTonDemo2 getInstance(){
        if (instance==null){
            instance = new SingleTonDemo2();
        }
        return instance;
    }

}
class SingleTonDemo2Test{
    public static void main(String[] args) {
        //    new SingleTonDem02()会出错
        SingleTonDemo2 instance = SingleTonDemo2.getInstance();
        SingleTonDemo2 instance1 = SingleTonDemo2.getInstance();
        System.out.println(instance == instance1);
    }

}
