package com.psj.ReflectionTest.proxy;

/**
 * @Author:PSJ
 * @Date:2020/5/14 0014
 * @Descrption:com.psj.ReflectionTest.proxy
 * @Version:1.0
 */

import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理：没有显示的创建代理对象，可以与静态代理的main函数做对比
 */
interface Human{
    String getBelief();

    void eat(String food);
}
//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("喜欢吃" + food);
    }
}

class HumanUtil{
    public void method1(){
        System.out.println("****1111*******");
    }
    public void method2(){
        System.out.println("****2222*******");
    }
}


/**
 * 要实现动态代理需要解决的问题：
 * 1.如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
 * 2.当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a
 */
class ProxyFactory{
    //调用此静态方法返回一个代理类的对象，解决问题1
    public static Object getProxyInstance(Object obj){//obj就是被代理类的对象

        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                               obj.getClass().getInterfaces(),
                               handler);
    }
}
class MyInvocationHandler implements InvocationHandler{

    private Object obj;//需要使用被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj = obj;
    }
    //当通过代理类的对象,调用方法a时，就会自动的调用如下的invoke方法
    //将被代理类要执行的方法a的功能就声明在invoke方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil humanUtil = new HumanUtil();
        humanUtil.method1();

        //method:即为代理类对象调用的方法，也作为被代理类对象调用的方法
        //obj：被代理类的对象
        Object returnValue = method.invoke(obj, args);

        humanUtil.method2();

        //上述方法的返回值就作为当前类中的invoke()的返回值
        return returnValue;
    }
}
public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //proxyInstance：代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("sweet food");

        System.out.println("**************************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyClothFactory.productCloth();
    }
}
