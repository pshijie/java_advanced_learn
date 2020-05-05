package com.psj.io.ioStream;

/**
 * @Author:PSJ
 * @Date:2020/5/5 0005
 * @Descrption:com.psj.io.ioStream
 * @Version:1.0
 */

import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 在java.nio.file包下：
 * Path可以看做是java.io.file类的升级版本，可以表示文件或文件目录，与平台无关
 * 实例化Path:使用Paths.get()方法
 */
public class PathTest {
    @Test
    public void test(){
        Path path = Paths.get("hello.txt");
//        Path path2 = Paths.get("d:\\","hello.txt");
        System.out.println(path);

        File file = path.toFile();//Path-->File

        Path toPath = file.toPath();//File-->Path
    }
}
