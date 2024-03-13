package learnjava_09;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        SafeSellTicket5 st21 = new SafeSellTicket5();
        SafeSellTicket5 st22 = new SafeSellTicket5();
        SafeSellTicket5 st23 = new SafeSellTicket5();

        st21.setName("窗口1");
        st22.setName("窗口2");
        st23.setName("窗口3");

        st21.start();
        st22.start();
        st23.start();

    }
}

class SafeSellTicket5 extends Thread {
    //    int ticket = 100;
    static int ticket = 100;

    // 需要确保多个线程共用一个Lock实例，需要将此对象声明为static final
    private static final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                // 锁定对共享资源的调用
                lock.lock();

                if (ticket > 0) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                // 解除对共享资源的调用的锁定
                lock.unlock();
            }

        }
    }
}
