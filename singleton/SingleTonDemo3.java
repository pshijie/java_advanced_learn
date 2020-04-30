package com.psj.singleton;

/**
 * @Author:PSJ
 * @Date:2020/3/23 0023
 * @Descrption:com.psj.singleton
 * @Version:1.0
 */


//DCL懒汉式
public class SingleTonDemo3 {
    //    1.构造器私有化
    private SingleTonDemo3(){}
    //    2.类初始化时就，不立即加载该对象
    private volatile static SingleTonDemo3 instance;

    //    3.提供获取该对象的方法，有synchroniz，效率低
    public static SingleTonDemo3 getInstance(){
        if (instance==null){
            synchronized (SingleTonDemo3.class){
                if(instance==null){
                    instance = new SingleTonDemo3();
                }
            }
        }
        return instance;
    }
}
class SingleTonDemo3Test{
    public static void main(String[] args) {
        //    new SingleTonDem02()会出错
        SingleTonDemo3 instance = SingleTonDemo3.getInstance();
        SingleTonDemo3 instance1 = SingleTonDemo3.getInstance();
        System.out.println(instance == instance1);
    }

}
