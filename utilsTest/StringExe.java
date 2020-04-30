package com.psj.utilsTest;

/**
 * @Author:PSJ
 * @Date:2020/4/21 0021
 * @Descrption:com.psj.utilsTest
 * @Version:1.0
 */
public class StringExe {
    String str = new String("good");
    char[] ch = {'t','e','s','t'};
    public void change(String str,char ch[]){
        str = "test ok";
        ch[0]='b';
    }

    public static void main(String[] args) {
        StringExe Exe = new StringExe();
        Exe.change(Exe.str,Exe.ch);
        System.out.println(Exe.str);//good,函数中的test ok在常量池中会重新创建（字符串不可变性），这里的exe.str还是原来的
        System.out.println(Exe.ch);//best，ch数组是堆中的数据
    }
}
