package com.psj.io;

/**
 * @Author:PSJ
 * @Date:2020/4/30 0030
 * @Descrption:com.psj.io
 * @Version:1.0
 */

import java.io.File;

/**
 * 打印出指定目录所有文件的名称，包括子文件目录下的文件:使用递归
 */
public class FileExer {
    public static void main(String[] args) {
        File dir = new File("e:\\gitSpace");
        printSubFile(dir);
    }

    public static void printSubFile(File dir){
        File[] subfiles = dir.listFiles();
        for (File f : subfiles){
            if (f.isDirectory()){
                printSubFile(f);
            }else{
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}

