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
 * 客户端发送文件给服务端，服务端将文件保存在本地
 */
public class TCPTest2 {
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8899);

            outputStream = socket.getOutputStream();
            fileInputStream = new FileInputStream(new File("1.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                outputStream.write(buffer,0,len);
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
    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);

        Socket accept = serverSocket.accept();

        InputStream inputStream = accept.getInputStream();

        FileOutputStream fileOutputStream = new FileOutputStream(new File("server.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1){
            fileOutputStream.write(buffer,0,len);
        }

        fileOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
