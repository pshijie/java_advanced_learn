package com.psj.io.ioStream;

/**
 * @Author:PSJ
 * @Date:2020/5/5 0005
 * @Descrption:com.psj.io.ioStream
 * @Version:1.0
 */

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用：
 * 1.该类直接继承java.lang.Object类，实现了DataInput和DataOutput
 * 2.该类既可以作为一个输入流，也可作为一个输出流
 * 3.如果RandomAccessFile作为输出流，写出文件如果不存在，就自动创建，如果文件存在，就会对原有文件进行覆盖
 */
public class RandomAccessFileTest {

    @Test
    public void test(){
        RandomAccessFile randomAccessFile = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(new File("1.jpg"),"r");
            randomAccessFile2 = new RandomAccessFile(new File("RandomAccessFile.jpg"),"rw");

            byte[] buffer = new byte[1024];
            int len;

            while ((len=randomAccessFile.read(buffer)) != -1){
                randomAccessFile2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null){
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (randomAccessFile2 != null){
                try {
                    randomAccessFile2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2(){
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("helloRandomAccessFile.txt", "rw");
            //从下标为3开始覆盖,但不会把后面所有的内容覆盖，只会覆盖自己的长度
            randomAccessFile.seek(2);
            randomAccessFile.write("bbbb".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null){
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
