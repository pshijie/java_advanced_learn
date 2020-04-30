package com.psj.utilsTest;

/**
 * @Author:PSJ
 * @Date:2020/4/21 0021
 * @Descrption:com.psj.utilsTest
 * @Version:1.0
 */
public class Person {
    int age;
    String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
