package learnjava_09;

public class PrintNumber2 {
    public static void main(String[] args) {
        // 创建当前实现类的对象
        PrintOddNumber2 pon2 = new PrintOddNumber2();
        PrintEvenNumber2 pen2 = new PrintEvenNumber2();

        // 将此对象当做参数传递到Thread类的构造器中，创建Thread类的实例
        Thread t1 = new Thread(pon2);
        Thread t2 = new Thread(pen2);

        t1.start();
        t2.start();

        // 创建Runnable接口匿名实现类的匿名对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 10001; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "：" + i);
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 10001; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "：" + i);
                    }
                }
            }
        }).start();
    }
}

class PrintEvenNumber2 implements Runnable {
    // 实现接口中的run()方法
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

class PrintOddNumber2 implements Runnable {
    // 实现接口中的run()方法
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
