package com.learnjava;

public class Kid extends Mankind {
    private int age;


    public void setAge(int age) {
        this.age = age;
    }

    public void getAge() {
        System.out.println("age: " + age);
    }

    //重写父类方法
    //用super调用父类方法
    public void employed() {
        super.employed();
        System.out.println("kid should study and have no job");
    }

    public void getInfo() {
        System.out.println("kid' info");
    }
}
