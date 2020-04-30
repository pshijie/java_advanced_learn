package com.psj.EnumTest;

/**
 * @Author:PSJ
 * @Date:2020/4/24 0024
 * @Descrption:com.psj.EnumTest
 * @Version:1.0
 */
/*
类的对象是有限个且是确定的就称为枚举类
需要定义一组常量时，可以使用枚举类
枚举类中只有一个对象就是单例模式
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}
class Season{
    //1.声明Season对象的属性 ：用 private final修饰
    private final String seasonName;
    private final String seasonDesc;
    //2.私有化类的构造器,并给对象属性赋值
    private Season(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //3.提供当前枚举类的多个对象:public static final
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏暖花开");
    public static final Season AUTUMN = new Season("秋天","秋暖花开");
    public static final Season WINTER = new Season("冬天","冬暖花开");

    //4.其他述求：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

}
