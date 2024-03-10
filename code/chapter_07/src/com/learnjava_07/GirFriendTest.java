package com.learnjava_07;

public class GirFriendTest {
    public static void main(String[] args) {

    }
}

//懒汉式：延迟加载(类的唯一实例在需要使用的时候进行创建)，节省内存空间
class GirlFriend {
    //类构造器私有化
    private GirlFriend() {

    }

    //声明当前类的实例
    private static GirlFriend g = null;

    //使用getInstance()方法获取当前类的实例，如果未创建，则在方法内部进行创建
    public static GirlFriend getInstance() {
        if (g == null) {
            g = new GirlFriend();
        }
        return g;
    }
}
