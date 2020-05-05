package com.psj.io.ioStream;

/**
 * @Author:PSJ
 * @Date:2020/5/3 0003
 * @Descrption:com.psj.io.ioStream
 * @Version:1.0
 */

import org.junit.Test;

import javax.crypto.interfaces.PBEKey;
import java.io.*;

/**
其他流的使用：
 1.标准的输入输出
 2.打印流
 3.数据流
 */
public class OtherStreamTest {
    /*1.标准的输入输出
        Systeam.in:默认从键盘输入
        Systeam.out:默认从控制台输出
     */

    //读入输入的数据，读到e或者exit就输出,否则将输入的字符串转为大写
    //Systeam.in ->> 转换流(键盘的输入的由字节转换为字符输入) ->> BufferReader的readLine()
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            //这一步就不是从文件读入，而是读键盘的输入
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(inputStreamReader);

            while (true){
                System.out.println("输入字符串：");
                String data = bufferedReader.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                String upper = data.toUpperCase();
                System.out.println(upper);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 2.打印流 PrintStream和PrintWriter
     */
    @Test
    public void test2(){
        PrintStream ps = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("PrintStream.txt"));
            ps = new PrintStream(fileOutputStream,true);
            if (ps != null){    //将原本从控制台输出修改为输出到文件
                System.setOut(ps);
            }
            for (int i = 0;i<=255;i++){
                System.out.print((char)i);
                if (i%50==0){
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null){

                ps.close();
            }
        }

    }

    /**
     *3.数据流 DataInputStream和DataOutputStream
     * 作用：方便操作java中的基本数据类型和String的数据
     */
    @Test
    public void test3(){    //直接打开文本会出现乱码
        DataOutputStream dataOutputStream  = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream("dataOutputStream.txt"));
            //writeUTF是写入字符串
            dataOutputStream.writeUTF("pshijie");
            dataOutputStream.writeInt(22);
            dataOutputStream.writeBoolean(true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataOutputStream != null){

                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test4(){
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream("dataOutputStream.txt"));
            //*读的过程要与写的顺序一致
            String name = dataInputStream.readUTF();
            int age = dataInputStream.readInt();
            boolean isMale = dataInputStream.readBoolean();
            System.out.println(name+age+isMale);
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
            if (dataInputStream != null){
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
