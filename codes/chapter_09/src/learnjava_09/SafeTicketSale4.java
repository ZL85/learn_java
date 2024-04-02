package learnjava_09;

public class SafeTicketSale4 {
    public static void main(String[] args) {
        SafeSellTicket4 st21 = new SafeSellTicket4();
        SafeSellTicket4 st22 = new SafeSellTicket4();
        SafeSellTicket4 st23 = new SafeSellTicket4();

        st21.setName("窗口1");
        st22.setName("窗口2");
        st23.setName("窗口3");

        st21.start();
        st22.start();
        st23.start();

    }
}

class SafeSellTicket4 extends Thread {
    //    int ticket = 100;
    static int ticket = 100;
    static boolean isFlag = true;

    @Override
    public void run() {
        while (isFlag) {
            sellTicket();
        }
    }

    public void sellTicket() { //方法非静态，此时同步监视器是this (不唯一)
        synchronized (SafeSellTicket4.class) {
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
}
