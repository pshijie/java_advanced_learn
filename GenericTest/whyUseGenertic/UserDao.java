package com.psj.GenericTest.whyUseGenertic;

/**
 * @Author:PSJ
 * @Date:2020/4/29 0029
 * @Descrption:com.psj.GenericTest.whyUseGenertic
 * @Version:1.0
 */
public class UserDao extends BaseDao<User> {//只能操作某一个表的
    @Override
    public void add(User user) {
        super.add(user);
    }
}
