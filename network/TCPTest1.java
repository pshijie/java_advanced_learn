package com.psj.network;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author:PSJ
 * @Date:2020/5/8 0008
 * @Descrption:com.psj.network
 * @Version:1.0
 */

/**
 * 客户端发送信息给服务端，服务端将数据显示在控制台上
 */
public class TCPTest1 {
    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            //指明服务器的IP和端口号
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 8899);

            //获取输出流，用于输出数据
            outputStream = socket.getOutputStream();
            outputStream.write("hello,我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
        }

    }
    //服务端
    @Test
    public void server()  {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            //创建服务器端的socket,指明自己的端口号（服务器端不用写明IP）
            serverSocket = new ServerSocket(8899);

            //接收到客户端的socket
            socket = serverSocket.accept();

            //获取输入流
            inputStream = socket.getInputStream();

            //不建议这么写，如果new byte的数组较小就可能会有乱码（传过来的内容中有中文）
//        byte[] buffer = new byte[5];
//        int len;
//        while ((len = inputStream.read(buffer)) != -1){
            //这里每取字节就转为字符串，有可能就把一个汉字（3个字节）拆开了
//            String s = new String(buffer, 0, len);
//            System.out.println(s);
//        }

            //读取输入流的数据
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = inputStream.read(buffer)) != -1){
                //byteArrayOutputStream将所有段的字节全部存储下来，最后输出
                byteArrayOutputStream.write(buffer,0,len);
            }
            System.out.println(byteArrayOutputStream.toString());

            System.out.println("收到来自于："+socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
            if (socket != null){

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null){

                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
