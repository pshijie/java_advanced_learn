package com.psj.io.ioStream;

/**
 * @Author:PSJ
 * @Date:2020/5/3 0003
 * @Descrption:com.psj.io.ioStream
 * @Version:1.0
 */

import org.junit.Test;

import java.io.*;
import java.sql.BatchUpdateException;

/**
 * 处理流中的转换流的使用(属于字符流，后面是Reader和Writer)：提供字节流和字符流之间的转换
 * 1.InputStreamReader：将字节的输入流转换为字符的输入流（对应解码的过程）
 * 2.OutputStreamWriter：将字符的输出流转换为字节的输出流（对应编码的过程）
 */
public class InputStreamReaderTest {
    @Test
    public void test(){
        InputStreamReader inputStreamReader = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("hello.txt");
//        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);//使用系统默认的字符集
            //第二个参数指明字符集，具体使用哪个字符集，取决于文件保存时使用的字符集
            inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");

            char[] buffer = new char[100];
            int len;
            //相当于在FileReader的基础上实现多个字符的读取
            while ((len = inputStreamReader.read(buffer)) != -1){
                String s = new String(buffer, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2(){
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            File file = new File("hello.txt");
            File file1 = new File("hello_gbk.txt");

            inputStreamReader = new InputStreamReader(new FileInputStream(file), "utf-8");
            //写入文件时使用gbk，生成的文件就要使用gbk才可以正常解码去读
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file1), "gbk");

            char[] buffer = new char[100];
            int len;
            while ((len = inputStreamReader.read(buffer)) != -1)
            {
                outputStreamWriter.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStreamWriter != null){
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
