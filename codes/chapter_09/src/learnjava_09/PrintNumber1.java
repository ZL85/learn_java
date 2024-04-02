package learnjava_09;

public class PrintNumber1 {
    public static void main(String[] args) {
        // 创建当前Thread的子类对象，通过对象调用start()方法
        PrintEvenNumber1 pen1 = new PrintEvenNumber1();
        pen1.start();
//        pen1.run(); //不会启动新线程
//        pen1.start();

        PrintOddNumber1 pon1 = new PrintOddNumber1();
        pon1.start();

        // main所在的线程执行的操作
        for (int i = 1; i < 10001; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }

        // 创建Thread类的匿名子类的匿名对象
        new Thread() {
            @Override
            public void run() {
                // 将此线程要执行的操作声明在此方法体中
                for (int i = 1; i < 10001; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "：" + i);
                    }
                }
            }
        }.start();
    }
}

// 创建一个继承Thread类的子类
class PrintEvenNumber1 extends Thread {
    // 重写Thread类的run()方法
    @Override
    public void run() {
        // 将此线程要执行的操作声明在此方法体中
        for (int i = 1; i < 10001; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }
    }
}

class PrintOddNumber1 extends Thread {
    // 重写Thread类的run()方法
    @Override
    public void run() {
        // 将此线程要执行的操作声明在此方法体中
        for (int i = 1; i < 10001; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }
    }
}
