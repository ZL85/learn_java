package learnjava_09;

public class SafeTicketSale2 {
    public static void main(String[] args) {
        SafeSellTicket2 st21 = new SafeSellTicket2();
        SafeSellTicket2 st22 = new SafeSellTicket2();
        SafeSellTicket2 st23 = new SafeSellTicket2();

        st21.setName("窗口1");
        st22.setName("窗口2");
        st23.setName("窗口2");

        st21.start();
        st22.start();
        st23.start();

    }
}

class SafeSellTicket2 extends Thread {
    //    int ticket = 100;
    static int ticket = 100;
//    static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (SafeSellTicket2.class) { //Class cls = SafeSellTicket2.class
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
