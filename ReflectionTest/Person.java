package com.psj.ReflectionTest;

/**
 * @Author:PSJ
 * @Date:2020/5/10 0010
 * @Descrption:com.psj.ReflectionTest
 * @Version:1.0
 */
public class Person {
    private String name;
    public int age;

    public Person() {
        System.out.println("调用空参构造器");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show(){
        System.out.println("show方法被调用");
    }
    private String showNation(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }
}
