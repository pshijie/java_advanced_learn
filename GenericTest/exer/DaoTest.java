package com.psj.GenericTest.exer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:PSJ
 * @Date:2020/4/29 0029
 * @Descrption:com.psj.GenericTest.exer
 * @Version:1.0
 */
public class DaoTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("1001",new User(1001,34,"psj"));
        dao.save("1002",new User(1002,35,"psj1"));
        dao.save("1003",new User(1003,36,"psj2"));

        dao.update("1003",new User(1003,333,"psj4"));
        dao.delete("1001");
        List<User> list = dao.list();
        list.forEach(System.out::println);
    }
}
