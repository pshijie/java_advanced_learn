package com.psj.io.exer;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author:PSJ
 * @Date:2020/5/3 0003
 * @Descrption:com.psj.io.exer
 * @Version:1.0
 */
public class WordCount {//计算文本的字符个数
    @Test
    public void testWordCount(){
        FileReader fileReader = null;
        BufferedWriter bw = null;
        try {
            Map<Character, Integer> map = new HashMap<>();
            fileReader = new FileReader(new File("hello.txt"));
            int c = 0;
            while ((c = fileReader.read()) != -1){
                //将int还原为char
                char ch  = (char) c;
                if (map.get(ch) == null){
                    map.put(ch,1);
                }else
                {
                    map.put(ch,map.get(ch)+1);
                }
            }

            bw = new BufferedWriter(new FileWriter(new File("wordcount.txt")));
            Set<Map.Entry<Character,Integer>> entrySet = map.entrySet();
            for (Map.Entry<Character,Integer> entry : entrySet){
                switch (entry.getKey()){
                    case ' ':
                        bw.write("空格=" + entry.getValue());
                        break;
                    case '\t':
                        bw.write("tab键=" + entry.getValue());
                        break;
                    case '\r':
                        bw.write("回车=" + entry.getValue());
                        break;
                    case '\n':
                        bw.write("换行=" + entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey() + "=" + entry.getValue());
                        break;
                }
                //换行继续计算
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
