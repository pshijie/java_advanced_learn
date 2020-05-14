package com.psj.ReflectionTest.proxy;

/**
 * @Author:PSJ
 * @Date:2020/5/14 0014
 * @Descrption:com.psj.ReflectionTest.proxy
 * @Version:1.0
 */

/**
 * 静态代理：代理类和被代理类在编译期间就确定下来了
 */
interface ClothFactory{
    void productCloth();
}
//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;//用拿被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void productCloth() {
        System.out.println("代理工厂的准备工作");
        factory.productCloth();
        System.out.println("代理工厂后续收尾");
    }
}
//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void productCloth() {
        System.out.println("nike工厂生产运动服");
    }
}
public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理对象
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        //创建代理对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);
        proxyClothFactory.productCloth();
    }
}
