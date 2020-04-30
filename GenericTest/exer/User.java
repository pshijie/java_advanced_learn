package com.psj.GenericTest.exer;

import java.util.Objects;

/**
 * @Author:PSJ
 * @Date:2020/4/29 0029
 * @Descrption:com.psj.GenericTest.exer
 * @Version:1.0
 */
public class User {
    private int id;
    private int age;
    private String name;

    public User() {
    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                getAge() == user.getAge() &&
                Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getAge(), getName());
    }
}
