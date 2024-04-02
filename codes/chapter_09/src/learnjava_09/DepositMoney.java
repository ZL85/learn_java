package learnjava_09;

public class DepositMoney {
    public static void main(String[] args) {
        Account account = new Account();

        Customer customer1 = new Customer(account, "customer1");
        Customer customer2 = new Customer(account, "customer2");

        customer1.start();
        customer2.start();
    }
}

class Account {
    private double balance; //余额

    public synchronized void deposit(double amount) { //this 指account，唯一
        if (amount > 0) {
            balance += amount;
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + "存钱1000块，余额为：" + balance);
    }
}

class Customer extends Thread {
    Account account;

    public Customer(Account account) {
        this.account = account;
    }

    public Customer(Account account, String name) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            account.deposit(1000);
        }
    }
}
