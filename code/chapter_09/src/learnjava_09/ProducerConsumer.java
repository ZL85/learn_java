package learnjava_09;

public class ProducerConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p = new Producer(clerk);
        Consumer c = new Consumer(clerk);

        p.setName("producer");
        c.setName("consumer");

        p.start();
        c.start();
    }
}

class Clerk { //店员
    private int productNumber = 0; //产品数量

    public synchronized void addProductNumber() {
        if (productNumber >= 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            productNumber++;
            System.out.println(Thread.currentThread().getName() + " produced the " + productNumber + " product.");
            notifyAll();
        }
    }

    public synchronized void minusProductNumber() {
        if (productNumber <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " consumed the " + productNumber + " product.");
            productNumber--;
            notifyAll();
        }
    }
}

class Producer extends Thread { //生产者
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Producer starts to produce product：");
            clerk.addProductNumber();
        }
    }
}

class Consumer extends Thread { //消费者
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Consumer starts to consume product：");
            clerk.minusProductNumber();
        }
    }
}
