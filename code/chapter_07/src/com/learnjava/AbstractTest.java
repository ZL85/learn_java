package com.learnjava;

public class AbstractTest {
    public static void main(String[] args) {
        //整型常量
        final int I = 66;
        System.out.println(I);

        Student s1 = new Student("zl", 25, "ahu");
        String info = s1.getInfo();
        System.out.println(info);
    }
}
