package com.learnjava_06;

import java.io.File;
import java.util.Objects;

public class OverwriteEquals {
    public static void main(String[] args) {
        User u1 = new User("tom", 25);
        User u2 = new User("tom", 25);
        System.out.println(u1.equals(u2));  //false before overwrite

        //对于像string、File、Date和包装类等，它们都重写了0bject类中的equals()方法，用于比较两个对象的实体内容是否相等
        String s1 = "hello";
        String s2 = new String("hello");
        System.out.println(s1.equals(s2));  //true

        File f1 = new File("d:\\ab.txt");
        File f2 = new File("d:\\ab.txt");
        System.out.println(f1.equals(f2));  //true

        //数组使用equals()
        int[] arr = new int[10];
        System.out.println(arr.equals(new int[10]));  //false

    }

}

class User {
    String name;
    int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    public boolean equals(Object anObject) {
//        if (this == anObject) {
//            return true;
//        }
//
//        if (anObject instanceof User) {
//            User user = (User) anObject;
////            if (this.age == user.age && this.name.equals(user.name)) {
////                return true;
////            } else {
////                return false;
////            }
//            return this.age == user.age && this.name.equals(user.name);
//        }
//
//        return false;
//    }

    //idea自动实现方法重写
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }
}
