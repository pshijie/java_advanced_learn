package com.psj.io.ioStream;

/**
 * @Author:PSJ
 * @Date:2020/5/3 0003
 * @Descrption:com.psj.io.ioStream
 * @Version:1.0
 */

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
其他流的使用：
 1.标准的输入输出
 2.打印流
 3.数据流
 */
public class OtherStreamTest {
    /*1.标准的输入输出
        Systeam.in:默认从键盘输入
        Systeam.out:默认从控制台输出
     */

    //读入输入的数据，读到e或者exit就输出,否则将输入的字符串转为大写
    //Systeam.in ->> 转换流(键盘的输入的由字节转换为字符输入) ->> BufferReader的readLine()
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            //这一步就不是从文件读入，而是读键盘的输入
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(inputStreamReader);

            while (true){
                System.out.println("输入字符串：");
                String data = bufferedReader.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                String upper = data.toUpperCase();
                System.out.println(upper);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
