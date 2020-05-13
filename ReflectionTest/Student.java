package com.psj.ReflectionTest;

/**
 * @Author:PSJ
 * @Date:2020/5/13 0013
 * @Descrption:com.psj.ReflectionTest
 * @Version:1.0
 */
@MyAnnotation(value = "hi")
public class Student extends Creature<String> implements Comparable<String>,MyInterface {

    private String name;
    int age;
    public int id;

    public Student() {
    }

    @MyAnnotation(value = "aaa")
    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是："+nation);
        return nation;
    }
    public String display(String interests,int age){
        return interests + age;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是学生");
    }
}
