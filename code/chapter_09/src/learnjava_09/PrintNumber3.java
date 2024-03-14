package learnjava_09;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class PrintNumber3 {
    public static void main(String[] args) {
        //创建实现Callable接口的实现类的对象
        PrintEvenNumber3 pen3 = new PrintEvenNumber3();
        //将此Callable接口的实现类的对象作为参数传入Thread类的构造器中，创建Thread对象并调用start()方法
        FutureTask ft = new FutureTask(pen3);

        Thread t = new Thread(ft);

        t.start();

        Object count = null;
        try {
            //获取Callable中call()方法的返回值
            //get()返回值即为FutureTask构造器参数Callable接口的实现类重写的call()方法的返回值
            count = ft.get();
            System.out.println("偶数个数为：" + count);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

//创建一个实现Callable接口的实现类
class PrintEvenNumber3 implements Callable {
    //实现接口中的call()方法，将线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int count = 0;
        for (int i = 1; i < 101; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
                count++;
            }
        }
        return count;
    }
}
