package com.psj.ReflectionTest;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author:PSJ
 * @Date:2020/5/10 0010
 * @Descrption:com.psj.ReflectionTest
 * @Version:1.0
 */

/**
 * 1.类的加载过程：
 * 程序经过javac.exe命令之后，会生成一个或多个字节码文件（.class），接着使用java.exe命令对某个字节码文件
 * 进行解释运行，相当于将某个字节码文件记载到内存中。加载到内存中的类就称为运行时类，这个运行时类就作为
 * Class的一个实例。 （换言之Class的实例就对应着一个运行时类）
 *
 * 2.加载到内存中的运行时类，会缓存一段时间，在此时间之内，可以通过不同的方式来获取此运行时的类
 *
 * 3.只要数组的元素类型与维度一样，就是同一个Class,比如 int[] a = new int[10]和int[] b = new int[100]
 *   就是同一个Class（都是一维数组，且都是int类型）
 */
public class ReflectionTest {
    //使用反射前，对于Person类的操作
    @Test
    public void test(){
        Person p1 = new Person("psj", 22);
        p1.age = 222;
        System.out.println(p1.toString());

        //无法调用私有的方法,构造器
    }

    //使用反射后，对于Person类的操作
    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        //通过反射创建对象
        Constructor constructor = clazz.getConstructor(String.class, int.class);

        Object o = constructor.newInstance("psj", 22);
        Person p = (Person) o;
        System.out.println(p);

        //通过反射，调用对象指定的属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,222);
        System.out.println(p);

        //通过反射，调用对象指定的方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("*************************");

        //通过反射，调用对象私有的构造器
        Constructor constructor1 = clazz.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person p2 = (Person) constructor1.newInstance("psw");
        System.out.println(p2);

        //通过反射，调用对象私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2,"psw2");
        System.out.println(p2);

        //通过反射，调用对象私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p2, "中国");//相当于p2.showNation("中国")
        System.out.println(nation);

    }

    @Test
    public void test3() throws ClassNotFoundException {//获取Class的实例的方式
        //方式一：调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象,调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("com.psj.ReflectionTest.Person");//体现反射的动态性
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);//true
        System.out.println(clazz1 == clazz3);//true

        //方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.psj.ReflectionTest.Person");

    }

}
