package com.psj.io.exer;

import org.junit.Test;

import java.io.*;

/**
 * @Author:PSJ
 * @Date:2020/5/3 0003
 * @Descrption:com.psj.io.exer
 * @Version:1.0
 */
public class PicTest {

    //文件的加密（^5）
    @Test
    public void test1()  {
        FileInputStream fileInputStream = null;
        FileOutputStream testPic = null;
        try {
            fileInputStream = new FileInputStream(new File("1.jpg"));
            testPic = new FileOutputStream(new File("testPic.jpg"));

            byte[] buffer = new byte[20];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                //对数组进行加密
                for (int i = 0;i<len;i++){
                    buffer[i] = (byte) (buffer[i] ^5);
                }

                testPic.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (testPic != null){
                try {
                    testPic.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //文件的解密,就会再进行相同的一次异或运算
    @Test
    public void test2()  {
        FileInputStream fileInputStream = null;
        FileOutputStream testPic = null;
        try {
            fileInputStream = new FileInputStream(new File("testPic.jpg"));
            testPic = new FileOutputStream(new File("testPic1.jpg"));

            byte[] buffer = new byte[20];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                //对数组进行加密
                for (int i = 0;i<len;i++){
                    buffer[i] = (byte) (buffer[i] ^5);
                }

                testPic.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (testPic != null){
                try {
                    testPic.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
