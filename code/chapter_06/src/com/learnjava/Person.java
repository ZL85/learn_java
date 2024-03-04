package com.learnjava;

//高内聚：类的内部数据操作细节自己完成，不允许外部干涉
//低耦合：仅暴露少量的方法给外部使用，尽量方便外部调用
//封装(encapsulation)：把客观事物封装成抽象概念的类，并且类可以把自己的数据和方法只向可信的类或者对象开放，向没有必要开放的类或对象隐藏信息
//权限修饰符范围：private-->>缺省-->>protected-->>public
public class Person {
    //私有属性
    private int age;

    public void setAge(int a) {
        if (a <= 0 || a >= 130) {
            System.out.println("the age you input is illegal.");
        } else {
            age = a;
        }
    }

    public int getAge() {
        return age;
    }
}
