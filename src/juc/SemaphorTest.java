package juc;

import java.util.concurrent.Semaphore;

public class SemaphorTest {

    public static void main(String[] args) throws InterruptedException {
        Pay myPay = new Pay(3);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    myPay.doPay();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "T" + i).start();
        }
    }
}

class Pay {
    private Semaphore semaphore;

    Pay(int n) {
        this.semaphore = new Semaphore(n);
    }

    public void doPay() throws InterruptedException {
        semaphore.acquire();
        for (int j = 0; j < Integer.MAX_VALUE; j++) {
            int k = (int) (Math.random() * Integer.MAX_VALUE % 10000000);
            if (k == 666) {
//                System.out.println(j);
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " Payed");
        semaphore.release();
    }

}
