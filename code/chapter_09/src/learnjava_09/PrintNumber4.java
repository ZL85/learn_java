package learnjava_09;

import java.util.concurrent.*;

public class PrintNumber4 {
    public static void main(String[] args) {
        //提供指定线程数量的线程池
        ExecutorService es = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) es;
        System.out.println(es.getClass());
        //设置线程池的属性
        tpe.setMaximumPoolSize(50); //设置线程池中线程数的上限

        //执行指定的线程操作，需要提供实现Runnable接口或Callable接口实现类的对象
        es.execute((new PrintEvenNumber4()));
        es.execute((new PrintOddNumber4()));

//        es.submit(Callable callable);

        //关闭连接池
        es.shutdown();
    }
}

class PrintEvenNumber4 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }
    }
}

class PrintOddNumber4 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }
    }
}
