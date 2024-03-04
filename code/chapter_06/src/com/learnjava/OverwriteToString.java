package com.learnjava;

import java.io.File;
import java.util.Date;

public class OverwriteToString {
    public static void main(String[] args) {
        User1 u1 = new User1("jerry", 12);
        System.out.println(u1);  //com.learnjava.User1@3b07d329 User1{name='jerry', age=12}
        System.out.println(u1.toString());  //com.learnjava.User1@3b07d329 User1{name='jerry', age=12}

        String s1 = "hello";
        System.out.println(s1);  //hello
        System.out.println(s1.toString());  //hello

        File f1 = new File("d:\\ab.txt");
        System.out.println(f1);  //d:\ab.txt
        System.out.println(f1.toString());  //d:\ab.txt

        Date d1 = new Date();
        System.out.println(d1);  //Sun Oct 22 10:18:41 CST 2023
        System.out.println(d1.toString());  //Sun Oct 22 10:18:41 CST 2023
    }
}

class User1 {
    String name;
    int age;

    public User1() {

    }

    public User1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
