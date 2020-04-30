package com.psj.CollectionTest;

import java.util.Objects;

/**
 * @Author:PSJ
 * @Date:2020/4/25 0025
 * @Descrption:com.psj.CollectionTest
 * @Version:1.0
 */
public class Person implements Comparable{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("调用");
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Person person = (Person) obj;
        if (age != person.age)
            return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    //按照姓名排序
    @Override
    public int compareTo(Object o) {
        if (o instanceof Person){
            Person person = (Person)o;
            return this.name.compareTo(person.name);
        }else{
            throw new RuntimeException("类型不匹配");
        }
    }
}
