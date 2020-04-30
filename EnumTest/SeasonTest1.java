package com.psj.EnumTest;

import com.psj.AnnotationTest.MyAnnotationTest;

/**
 * @Author:PSJ
 * @Date:2020/4/24 0024
 * @Descrption:com.psj.EnumTest
 * @Version:1.0
 */
/*
使用enum关键字定义枚举类
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);
        System.out.println(Season1.class.getSuperclass());
        //列出枚举类有哪些常量
        Season1[] values = Season1.values();
        for (int i = 0; i<values.length; i++){
            System.out.println(values[i]);
            values[i].show();
        }
        //根据提供objName,返回枚举类中对象名是该名的对象
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
        winter.show();
    }
}
interface Info{
    void show();
}
enum Season1 implements Info{
    //1.提供当前枚举类的对象，多个对象间用‘，’隔开(这个要放在开头)
   SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天!");
        }
    },
   SUMMER("夏天","夏暖花开"){
       @Override
       public void show() {
           System.out.println("夏天!");
       }
   },
   AUTUMN("秋天","秋暖花开"){
       @Override
       public void show() {
           System.out.println("秋天!");
       }
   },
   WINTER("冬天","冬暖花开"){
       @Override
       public void show() {
           System.out.println("冬天！");
       }
   };

    //1.声明Season对象的属性 ：用 private final修饰(类也可以没有属性)
    private final String seasonName;
    private final String seasonDesc;
    //2.私有化类的构造器,并给对象属性赋值
    private Season1(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //4.其他述求：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public void show() {
//        System.out.println("demo1");
//    }
//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}


