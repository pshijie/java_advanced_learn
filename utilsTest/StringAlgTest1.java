package com.psj.utilsTest;

import org.junit.Test;

/**
 * @Author:PSJ
 * @Date:2020/4/23 0023
 * @Descrption:com.psj.utilsTest
 * @Version:1.0
 */
public class StringAlgTest1 {
    /**
     * 将一个字符串的指定部分进行反转，比如abcdefg->abfedcg
     */
    public String reverse(String str,int starIndex,int endIndex){//方法一：转换为char[]
        if (str!=null && str!=""){
            char[] arr = str.toCharArray();
            for (int x = starIndex,y = endIndex ; x<y ; x++,y--){
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }

    public String reverse1(String str,int starIndex,int endIndex){//方法二：使用String的拼接
        if (str!=null && str!=""){
            String reverseStr = str.substring(0,starIndex);
            for (int i = endIndex ; i>=starIndex ; i--){
                reverseStr += str.charAt(i);
            }
            reverseStr += str.substring(endIndex+1);
            return  reverseStr;
        }
        return null;
    }

    public String reverse2(String str,int starIndex,int endIndex) {//方法三：使用StringBuffer或StringBuilder
        if (str!=null && str!=""){
            StringBuilder builder = new StringBuilder(str.length());
            builder.append(str.substring(0,starIndex));
            for (int i = endIndex ; i>=starIndex ; i--){
                builder.append(str.charAt(i));
            }
            builder.append(str.substring(endIndex+1));
            return builder.toString();
        }
        return null;
    }
    @Test
    public void testReverse(){
        String str = "abcdefg";
        String reverse = reverse2(str, 2, 5);
        System.out.println(reverse);
    }

}
