package com.learnjava_02;

/*
在类体中所定义的变量被称为成员变量，成员变量在整个类中都有效。
如果在成员变量的类型前面加上关键字static，这样的成员变量称为静态变量。
静态变量的有效范围可以跨类，甚至可达到整个应用程序之内。
对于静态变量，除了能在定义它的类内存取，还能直接以“类名.静态变量”的方式在其他类内使用。

在类的方法体中定义的变量称为局部变量。局部变量只在当前代码块中有效。
*/
public class Variable {
    //成员变量
    static String str = "HELLO WORLD!";

    public static void main(String[] args) {
        System.out.println(str);

        //局部变量
        //局部变量可与成员变量的名字相同，此时成员变量在此方法中暂时失效。
        String str = "HELLO AHU!";
        System.out.println(str);

        //定义变量
        //数据类型 变量名称[=值]
        //定义byte型变量
        byte num = 66;
        System.out.println(num);

        //定义short型变量
        short num1 = 520;
        System.out.println(num1);

        //定义int型变量
        int num2 = 1314;
        System.out.println(num2);

        //定义long型变量
        //若赋给的值大于int型的最大值或小于int型的最小值，则需要在数字后加L或l，表示该数值为长整数
        long num3 = 2147483650L;
        System.out.println(num3);

        //定义float型变量
        //在默认情况下，小数都被看作double型
        //若使用float型小数，需要在小数后面添加F或f
        float num4 = 3.14F;
        System.out.println(num4);

        //定义double型变量
        double num5 = 2.7654321D;
        System.out.println(num5);

        //定义char类型变量
        char char1 = 'a';
        System.out.println(char1 + "\n" + (int) char1);

        //定义bool类型变量
        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1);
        System.out.println(b2);
    }
}
