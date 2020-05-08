package com.psj.network;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @Author:PSJ
 * @Date:2020/5/9 0009
 * @Descrption:com.psj.network
 * @Version:1.0
 */

/**
 * Tips:UDP可先启动客户端，再启动服务端。而TCP则会报错
 */
public class UDPTest {
    @Test
    public void sender() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();

        String s = "UDP方式发送的";
        byte[] data = s.getBytes();

        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        //以数据报的形式发送
        DatagramPacket datagramPacket = new DatagramPacket(data,0,data.length,inetAddress,9090);

        datagramSocket.send(datagramPacket);

        datagramSocket.close();

    }

    @Test
    public void receive() throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(9090);

        byte[] buffer = new byte[100];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);

        datagramSocket.receive(datagramPacket);

        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));

        datagramSocket.close();

    }
}
