package com.learnjava;


public class WaterTest {
    public static void main(String[] args) {

        Water w1 = Water.getInstance();
        Water w2 = Water.getInstance();

        System.out.println(w1);
        System.out.println(w2);
        System.out.println(w1 == w2);  //true
    }

}

//单例模式
//饿汉式：立即加载(随着类的加载，当前的唯一实例就创建了)，线程安全
class Water {
    //类构造器私有化
    private Water() {

    }

    //在类内部创建当前类的实例
    //必须声明为static
    private static Water w = new Water();

    //使用getInstance()方法获取当前类的实例，必须声明为static
    public static Water getInstance() {
        return w;
    }
}


