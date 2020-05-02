package com.psj.io.ioStream;

import org.junit.Test;

import java.io.*;

/**
 * @Author:PSJ
 * @Date:2020/5/2 0002
 * @Descrption:com.psj.io.ioStream
 * @Version:1.0
 */
/*
Tips:1.如果文本中的字符全是英文字母，此时使用FileInputStream去读是没问题的，
     因为FileInputStream处理的是byte，而一个字母不会超过一个byte的范围的。
     但是如果文本中有中文，就会出现乱码，一个中文是一个字符，3个字节（utf-8）
     2.FileInputStream去读入文本虽然会出现乱码，但是如果不做输出，而是将读入
     的内容直接用FileOutStream写入另一个文件是可以的，被写入的文本是不会有乱码的

 */
public class FileInputOutputStreamTest {
    @Test
    public void testFileInputStream() throws IOException {//将文本用FileInputStream处理，可能会出现乱码
        FileInputStream fileInputStream = null;
        try {
            File file = new File("hello.txt");
            fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[5];//将char换为byte，因为FileInputStream是操作字节的
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                String s = new String(buffer,0,len);
                System.out.print(s);    //出现中文字符便出现乱码
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
        }
    }

    @Test
    public void testFileInputOutputStream() {//对图片的复制
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File srcFile = new File("1.jpg");
            File destFile = new File("2.jpg");

            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null){

                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream!=null){

                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void copyFile(String srcPath, String destPath){//指定路径下的复制
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null){

                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream!=null){

                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();
        String srcPath = "1.jpg";
        String destPath = "3.jpg";
        copyFile(srcPath,destPath);
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为："+ (end - start));
    }
}
