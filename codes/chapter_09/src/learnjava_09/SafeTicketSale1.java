package learnjava_09;

public class SafeTicketSale1 {
    public static void main(String[] args) {
        SafeSellTicket1 st1 = new SafeSellTicket1();

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

class SafeSellTicket1 implements Runnable {
    int ticket = 100;
//    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (this) {
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
            }
        }
    }
}
