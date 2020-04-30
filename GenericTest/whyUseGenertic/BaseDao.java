package com.psj.GenericTest.whyUseGenertic;

/**
 * @Author:PSJ
 * @Date:2020/4/29 0029
 * @Descrption:com.psj.GenericTest.whyUseGenertic
 * @Version:1.0
 */
public class BaseDao<T> {//表的共性操作
    //新增
    public void add(T t){
        System.out.println("新增");
    }
}
