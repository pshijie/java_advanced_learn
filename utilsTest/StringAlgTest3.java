package com.psj.utilsTest;

import com.psj.singleton.SingleTonDemo4;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author:PSJ
 * @Date:2020/4/23 0023
 * @Descrption:com.psj.utilsTest
 * @Version:1.0
 */
public class StringAlgTest3 {
    /**
     * 获取两个字符串中的最大相同子串，前提条件：两个字符串中只有一个最大相同子串
     */
    public String getMaxSameString(String str1,String str2){
        if (str1 != null && str2 != null){
            String maxStr = (str1.length() >= str2.length())? str1 : str2;
            String minStr = (str1.length() < str2.length())? str1 : str2;
            int length = minStr.length();
            //第一层循环不断缩小区间的大小
            for (int i = 0; i<length ; i++) {
                //第二层循环不断移动区间
                for (int x = 0,y = length-i; y<=length ;x++,y++){
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)){
                        return subStr;
                    }
                }
            }
        }
        return null;
    }
    //存在多个长度相同的最长子串
    public String[] getMaxSameString1(String str1,String str2){
        if (str1 != null && str2 != null){
            StringBuffer buffer = new StringBuffer();
            String maxStr = (str1.length() >= str2.length())? str1 : str2;
            String minStr = (str1.length() < str2.length())? str1 : str2;
            int length = minStr.length();
            //第一层循环不断缩小区间的大小
            for (int i = 0; i<length ; i++) {
                //第二层循环不断移动区间
                for (int x = 0,y = length-i; y<=length ;x++,y++){
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)){
                        buffer.append(subStr + ",");
                    }
                }
                if (buffer.length() != 0){
                    break;
                }
            }
            //将以","为结尾的部分换为""，即123,123，->123,123
            String[] split = buffer.toString().replaceAll(",$","").split("\\,");
            return split;
        }
        return null;
    }

    @Test
    public void testGetMaxSameString(){
        String str1 = "abcwerthello1yuiodefabcdef";
        String str2 = "cvhello1bnmabcdef";
        String[] sameString =getMaxSameString1(str1,str2);
        System.out.println(Arrays.toString(sameString));
//        String sameString = getMaxSameString(str1, str2);
//        System.out.println(sameString);
    }

    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());//4
        System.out.println(sb);//"null"，不是null
        StringBuffer sb1 = new StringBuffer(str);//抛异常
        System.out.println(sb1);
    }
}
