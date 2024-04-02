package learnjava_09;

public class UnsafeTicketSale2 {
    public static void main(String[] args) {
        UnsafeSellTicket2 st21 = new UnsafeSellTicket2();
        UnsafeSellTicket2 st22 = new UnsafeSellTicket2();
        UnsafeSellTicket2 st23 = new UnsafeSellTicket2();

        st21.setName("窗口1");
        st22.setName("窗口2");
        st23.setName("窗口3");

        st21.start();
        st22.start();
        st23.start();

    }
}

class UnsafeSellTicket2 extends Thread {
    //    int ticket = 100;
    static int ticket = 100;

    @Override
    public void run() {
        while (true) {
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
