package learnjava_09;

public class GirlFriendTest {
    static GirlFriend g1 = null;
    static GirlFriend g2 = null;

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                g1 = GirlFriend.getInstance();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                g2 = GirlFriend.getInstance();
            }
        };

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(g1);
        System.out.println(g2);
        System.out.println(g1 == g2);
    }
}

//懒汉式：延迟加载(类的唯一实例在需要使用的时候进行创建)，节省内存空间
class GirlFriend {
    //类构造器私有化
    private GirlFriend() {
    }

    //声明当前类的实例
    //加一个volatile可以避免指令重排
    private static volatile GirlFriend instance = null;

    //使用getInstance()方法获取当前类的实例，如果未创建，则在方法内部进行创建
//    public static synchronized GirlFriend getInstance() { //同步监视器是当前类本身
//        if (instance == null) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//            instance = new GirlFriend();
//        }
//        return instance;
//    }

//    public static GirlFriend getInstance() { //同步监视器是当前类本身
//        synchronized (GirlFriend.class) {
//            if (instance == null) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//                instance = new GirlFriend();
//            }
////            return instance; //也可放在这
//        }
//        return instance;
//    }

    public static GirlFriend getInstance() { //同步监视器是当前类本身
        // 提高效率
        if (instance == null) {
            synchronized (GirlFriend.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    instance = new GirlFriend();
                }
            }
        }
        return instance;
    }
}
