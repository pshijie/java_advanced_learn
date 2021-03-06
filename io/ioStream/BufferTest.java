package com.psj.io.ioStream;

/**
 * @Author:PSJ
 * @Date:2020/5/3 0003
 * @Descrption:com.psj.io.ioStream
 * @Version:1.0
 */

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 * BufferInputStream
 * BufferOutputStream
 * BufferReader
 * BufferWriter
 *
 * 提高读写速度的原因：内部提供了一个缓冲区
 * Tips:不管输入还是输出，都需要等到缓冲区满了才可以执行，执行flush()（刷新缓冲区）就可以立马将缓冲区的
 *      内容进行处理
 */
public class BufferTest {

    @Test
    public void BufferStreamTest() {//非文本的复制
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File srcFile = new File("1.jpg");
            File destFile = new File("buffer.jpg");

            //造流
            //1.造节点流
            FileInputStream fileInputStream = new FileInputStream(srcFile);
            FileOutputStream fileOutputStream = new FileOutputStream(destFile);

            //2.造缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] buffer = new byte[10];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1){//这里调用的就是buffer的read方法了
                bufferedOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null){

                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //*资源关闭：先关闭外层的流，再关闭内层的流
            //关闭外层流的时候，内层流会自动关闭，下面这两步可以省略
//        fileInputStream.close();
//        fileOutputStream.close();
        }

    }

    @Test
    public void testBufferedReaderBufferedWriter() {//使用BufferedReader和BufferedWriter实现对文本的复制
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            //直接使用匿名函数
            bufferedReader = new BufferedReader(new FileReader(new File("hello.txt")));
            bufferedWriter = new BufferedWriter(new FileWriter(new File("helloBw.txt")));

            //方法1：老方法用char数组
//            char[] buffer = new char[5];
//            int len;
//            while ((len = bufferedReader.read(buffer)) != -1){
//                bufferedWriter.write(buffer,0,len);
//    //            bufferedWriter.flush();//可以不写
//            }

            //方法2：直接一行一行读,readLine方法
            String data;
            while ((data = bufferedReader.readLine()) != null)
            {
//                bufferedWriter.write(data);//不包含换行符，如果文本有多行全部写在一行里面

//                //换行方法1：
//                bufferedWriter.write(data + "\n");
                //换行方法2:
                bufferedWriter.write(data);
                bufferedWriter.newLine();//换行
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
