package com.psj.utilsTest;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author:PSJ
 * @Date:2020/4/22 0022
 * @Descrption:com.psj.utilsTest
 * @Version:1.0
 */
public class StringBufferAndBuilderTest {
    /**
     * StringBuffer:可变，安全，效率低
     * StringBuffer s = new StringBuffer()底层创建了一个长度了16的char数组
     * StringBuffer/StringBulider扩容为原来容量的2倍加2，同时将原有的数组中的元素复制到新的数组
     * StringBuilder:可变，不安全，效率高
     */

    @Test
    public void Test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'s');
        System.out.println(sb1);
        sb1.append(-1);
        System.out.println(sb1);
        sb1.insert(1,"psj");
        System.out.println(sb1);
    }

    @Test
    public void Test2(){//做三者效率对比
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("sbuffer的执行时间："+(endTime-startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("sbulider的执行时间："+(endTime-startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text+=i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("string的执行时间："+(endTime-startTime));
    }

}
