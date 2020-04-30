package com.psj.singleton;

/**
 * @Author:PSJ
 * @Date:2020/3/23 0023
 * @Descrption:com.psj.singleton
 * @Version:1.0
 */

//静态内部类实现
public class SingleTonDemo4 {
    private SingleTonDemo4(){}
    private static class InnerClass{
        private static final  SingleTonDemo4 instance = new SingleTonDemo4();
    }
    public static SingleTonDemo4 getInstance(){
        return InnerClass.instance;
    }

}
