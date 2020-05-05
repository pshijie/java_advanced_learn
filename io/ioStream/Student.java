package com.psj.io.ioStream;

import java.io.Serializable;

/**
 * @Author:PSJ
 * @Date:2020/5/5 0005
 * @Descrption:com.psj.io.ioStream
 * @Version:1.0
 */
public class Student implements Serializable {
    public static final long serialVersionUID = 475463534532L;

    private static String name;
    private transient int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
