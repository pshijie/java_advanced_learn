package com.psj.io.ioStream;

/**
 * @Author:PSJ
 * @Date:2020/4/30 0030
 * @Descrption:com.psj.io.ioStream
 * @Version:1.0
 */

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 流的分类：
 * 1.操作数据单位：字节流（一般是视频），字符流（一般是文本文件）
 * 2.数据的流向：输入流(磁盘到程序)，输出流（程序到磁盘）
 * 3.流的角色：节点流（直接操作文件），处理流（在文件的外层包裹外壳，操作外壳）
 *
 * 流的体系结构
 * 抽象基类         节点流(文件流)        缓冲流（处理流）
 * InputStream      FileInputStream     BufferInputStream
 * OutputStream     FileOutputStream    BufferOutputStream
 * Reader           FileReader          BufferReader
 * Writer           FileWriter          BufferWriter
 *
 * Tips:1、在testFileReader中如果直接选择抛异常，假设在new FileReader时没问题，但是
 *      在read()出现了问题，此时就不会执行close()方法（对于数据库，IO流，Socket这些需要关闭）
 *      所以使用try-catch,并且在close的try-catch中需要判断是否为null(如果在new FileReader
 *      就出现异常，意味没有创建对象，这样直接跳到finally执行close方法就会报空指针异常)
 *      2.读入的文件一定要存在，否则会报FileNotFoundException
 */



public class FileReaderWriterTest {
    public static void main(String[] args) {
        File file = new File("hello.txt");//相较于当前的工程
        System.out.println(file.getAbsolutePath());
    }
    @Test
    public void testFileReader(){//使用read方法，每一次读入一个
        FileReader fr = null;
        try {
            File file = new File("hello.txt");//相较于当前的module
            //提供具体的流（相当于给一个管道）
            fr = new FileReader(file);

            //数据的读入：
            //read（）返回读入的一个字符，如果到达文件末尾就返回-1
//        int data = fr.read();
//        System.out.println(data);//104
//        while (data != -1){
//            System.out.print((char) data);
//            data = fr.read();
//        }

            //修改上面代码：
            int data;
            while ((data = fr.read()) != -1){//类似迭代器的it.next()
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //流的关闭操作
            try {
                if (fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testFileReader1() throws IOException {//对read方法的升级操作，每一次读入多个
        FileReader fileReader = null;
        try {
            //File类的实例化
            File file = new File("hello.txt");

            //流的实例化
            fileReader = new FileReader(file);

            //读入的操作
            //read(char[] buffer):表示每次读入cbuffer数组的字符个数，如果到文件末尾就返回-1
            char[] cbuffer = new char[5];
            int len;
            while ((len = fileReader.read(cbuffer)) != -1){
                //错误的写法，因为每次都会读入5个，当最后一组还剩3个时，会用之前组的字符去补满5个
//               for (int i = 0;i<cbuffer.length;i++){
//                   System.out.println(cbuffer[i]);
//               }

//                //正确1：
//                for (int i = 0;i < len;i++){
//                   System.out.println(cbuffer[i]);
//               }
               //正确2：
                String s = new String(cbuffer, 0, len);
                System.out.println(s);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            try {
                if (fileReader != null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
