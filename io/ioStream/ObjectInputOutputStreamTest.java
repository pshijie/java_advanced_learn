package com.psj.io.ioStream;

/**
 * @Author:PSJ
 * @Date:2020/5/5 0005
 * @Descrption:com.psj.io.ioStream
 * @Version:1.0
 */

import com.psj.CollectionTest.Person;
import org.junit.Test;

import java.io.*;

/**
 * 对象流：ObjectInputStream和ObjectOutputStream
 * 作用：用于储存和读取基本数据类型或对象的处理流
 *      ObjectInputStream：内存中的对象->存储中的文件或通过网络传输出去
 *      ObjectOutputStream：存储中的文件或通过网络接收过来->内存中的对象
 */
public class ObjectInputOutputStreamTest {
    /**
     * 序列化的过程：将内存中的java对象保存到磁盘中或通过网络传输出去
     *使用ObjectOutputStream
     *
     * 要一个java对象实现序列化：
     * 1.实现接口Serializable
     * 2.类要提供一个全局的常量serialVersionUID。
     *   如果不在实体类中去声明这个ID变量，该变量在类生成时会自动生成，但是
     *   如果类修改，这个ID也会修改。在反序列化的过程中，JVM会把传来的字节流中的ID与本实体类
     *   中的ID进行比较。因为ID值之前变了，所以比较时也就不一样了
     * 3.除了保证Person类需要实现接口外，还必须保证其内部所有属性也必须实现序列化
     *   （默认情况下，基本属性是可序列化的）
     *
     * 反序列化：将磁盘文件中的对象还原为内存中的一个java对象
     * 使用ObjectInputStream
     *
     * Tips:1.static和transient修饰的成员变量是不能被序列化的，当打印对象就不会有这些变量的值
     *      2.基本数据类型和String类型天然就是可序列化的，所以为了不每一次返回数据都进行序列化的过程
     *        因此使用json（字符串）返回
     */
    @Test
    public void testObjectOutputStream(){   //序列化
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.txt"));
            objectOutputStream.writeObject(new String ("this is a demo"));
            objectOutputStream.flush();

            objectOutputStream.writeObject(new Student("psj",22));
            objectOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test2(){    //反序列化
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("object.txt"));
            Object object = objectInputStream.readObject();
            String s = (String) object;

            Student student = (Student) objectInputStream.readObject();

            System.out.println(s);
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
