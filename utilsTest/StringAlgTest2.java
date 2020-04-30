package com.psj.utilsTest;

import org.junit.Test;

/**
 * @Author:PSJ
 * @Date:2020/4/23 0023
 * @Descrption:com.psj.utilsTest
 * @Version:1.0
 */
public class StringAlgTest2 {
    /**
     * 获取一个字符串在另一个字符串中出现的次数
     */
    public int getCount(String mainStr,String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if (mainLength >= subLength){
            //每次从index往后找是否有符合条件的
            while ((index = mainStr.indexOf(subStr,index)) != -1){
                count++;
                index += subLength;
            }
            return count;
        }else{
            return 0;
        }
    }

    @Test
    public void testGetCount(){
        String mainStr = "abkkcadkabkecfkaabkskab";
        String subStr = "ab";
        int count = getCount(mainStr, subStr);
        System.out.println(count);

    }
}
