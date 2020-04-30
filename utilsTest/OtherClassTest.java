package com.psj.utilsTest;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @Author:PSJ
 * @Date:2020/4/24 0024
 * @Descrption:com.psj.utilsTest
 * @Version:1.0
 */
public class OtherClassTest {
    @Test
    public void test1(){
        String javaVersion = System.getProperty("java.version");
        System.out.println(javaVersion);
        BigInteger integer = new BigInteger("11111111111111111111111111111111111111");
        System.out.println(integer);
    }
}
