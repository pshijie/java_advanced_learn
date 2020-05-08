package com.psj.network;

/**
 * @Author:PSJ
 * @Date:2020/5/6 0006
 * @Descrption:com.psj.network
 * @Version:1.0
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 1.如何准确定位网络上一台或多台主机
 * 2.找到主机后如何可靠高效进行数据传输
 *
 * 两个要素：1.IP和端口号 2.通信协议
 * Tips:HostName是域名，HostAddress是IP地址
 *
 * 端口号范围：0-65535（16位整数）
 *
 * 套接字Socket=IP地址+端口号
 *
 * TCP:1.使用前必须建立TCP连接
 *     2.传输前，采用三次握手，点对点通信，是可靠的
 *     3.在连接中可以进行大数据量的传输
 *     4.传输完毕，需要释放连接，效率低
 * UDP:1.将数据和源、目的封装为包，不需要建立连接
 *     2.每个数据报的大小限制在64K内
 *     3.不可靠
 *     4.可以广播发送
 *     5.发送数据结束时无需释放资源，开销小，速度快
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress byName = InetAddress.getByName("192.168.10.14");
            System.out.println(byName); // /192.168.10.14

            InetAddress name = InetAddress.getByName("www.atguigu.com");
            System.out.println(name);   //www.atguigu.com/113.96.109.95

            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);//此时本机在局域网内的域名和IP
            System.out.println(localHost.getHostName());//域名
            System.out.println(localHost.getHostAddress());//IP地址
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
