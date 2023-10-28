package com.learnjava;

public class BlockTest {
    public static void main(String[] args) {
        System.out.println(Fish.info);

        Fish f = new Fish();
        f.eat();

    }
}

class Fish {
    String name;
    int age;
    static String info = "I'm a fish";

    public void eat() {
        System.out.println("fish eat");
    }

    public Fish() {

    }

    //代码块(可用static进行修饰)
    //静态代码块：随着类的加载只执行一次
    static {
        System.out.println("static block");
    }

    //非静态代码块：随着对象的创建而执行(每创建一次当前类的实例就会执行一次)
    {
        System.out.println("non-static block");
    }
}
