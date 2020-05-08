package com.psj.network;

/**
 * @Author:PSJ
 * @Date:2020/5/9 0009
 * @Descrption:com.psj.network
 * @Version:1.0
 */

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端发送文件给服务端，服务端将文件保存在本地,并返回发送成功给客户端
 * Tips:客户端调用shutdownOutput()方法关闭的是客户端的输出流，同时服务器端的输入流也随之关闭
 */
public class TCPTest3 {
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8899);

            outputStream = socket.getOutputStream();
            fileInputStream = new FileInputStream(new File("1.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                outputStream.write(buffer,0,len);
            }

            //*表示文件已经发完，不再输出数据（给服务器端明确的指示），不加这一句会报错
            socket.shutdownOutput();

            //接收来自服务端的数据，并显示
            inputStream = socket.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[20];
            int len1;
            while ((len1 = inputStream.read(buffer1)) != -1){
                byteArrayOutputStream.write(buffer1,0,len1);
            }
            System.out.println(byteArrayOutputStream.toString());

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
            if (outputStream != null){

                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (byteArrayOutputStream != null){
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);

        Socket accept = serverSocket.accept();

        InputStream inputStream = accept.getInputStream();

        FileOutputStream fileOutputStream = new FileOutputStream(new File("server2.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1){
            fileOutputStream.write(buffer,0,len);
        }
        //服务器给客户端的反馈
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("我已接收到数据".getBytes());


        fileOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
        outputStream.close();
    }
}
