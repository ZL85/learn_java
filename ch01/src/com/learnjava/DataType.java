package com.learnjava;
/*
在Java中有8种基本数据类型来存储数值、字符和布尔值。
数值型:
    byte
    short
    int
    long
    float
    double
字符型:
    char
布尔型:
    true
    false
*/
public class DataType {
    public static void main(String[] args) {
        //定义常量
        //final 数据类型 常量名称[=值]
        //常量名通常使用大写字母

        //定义byte型常量
        final byte RANK = 1;
        System.out.println(RANK);

        //定义short型常量
        final short GRADE = 100;
        System.out.println(GRADE);

        //定义int型常量
        final int AGE = 23;
        System.out.println(AGE);

        //定义long型常量
        final long NUMBER = 200000000L;
        System.out.println(NUMBER);

        //定义float型常量
        final float LOVE = 5.201314F;
        System.out.println(LOVE);

        //定义double型常量
        final double PI =3.1415926D;
        System.out.println(PI);

        //定义char类型常量
        final char WORD = 'A';
        System.out.println(WORD);

        //定义bool类型常量
        final boolean BOOL1 = true;
        System.out.println(BOOL1);
        final boolean BOOL2 = false;
        System.out.println(BOOL2);
    }
}
