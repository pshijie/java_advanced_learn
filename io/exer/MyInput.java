package com.psj.io.exer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author:PSJ
 * @Date:2020/5/3 0003
 * @Descrption:com.psj.io.exer
 * @Version:1.0
 */
public class MyInput {//模仿new Scanner（Systeam.in）读入不同类型的输入
    public static String readString(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        try {
            s = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return s;
    }

    public static int readInt(){
        return Integer.parseInt(readString());
    }

    public static double readDouble(){
        return Double.parseDouble(readString());
    }

    public static double readByte(){
        return Byte.parseByte(readString());
    }

    public static double readShort(){
        return Short.parseShort(readString());
    }

    public static double readLong(){
        return Long.parseLong(readString());
    }

    public static double readfloat(){
        return Float.parseFloat(readString());
    }

    public static void main(String[] args) {
        String s = MyInput.readString();
        System.out.println(s);
    }
}
