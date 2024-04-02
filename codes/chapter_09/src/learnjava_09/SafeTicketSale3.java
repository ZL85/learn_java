package learnjava_09;

public class SafeTicketSale3 {
    public static void main(String[] args) {
        SafeSellTicket3 st1 = new SafeSellTicket3();

        Thread t1 = new Thread(st1);
        Thread t2 = new Thread(st1);
        Thread t3 = new Thread(st1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class SafeSellTicket3 implements Runnable {
    int ticket = 100;
    boolean isFlag = true;

    @Override
    public void run() {
        while (isFlag) {
            sellTicket();
        }
    }

    public synchronized void sellTicket() { //方法非静态，此时同步监视器是this (唯一)
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket);
            ticket--;
        } else {
            isFlag = false;
        }
    }
}
