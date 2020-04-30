package com.psj.Thread;

/**
 * @Author:PSJ
 * @Date:2020/4/18 0018
 * @Descrption:com.psj.Thread
 * @Version:1.0
 */
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(i);
            }
        }
    }
}
public class ThreadTest{
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("hello");
    }
}
