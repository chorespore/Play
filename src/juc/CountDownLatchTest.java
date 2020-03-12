package juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);

        CountDownThread cdThread = new CountDownThread(latch);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(cdThread).start();
        }
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }


}

class CountDownThread implements Runnable {

    private CountDownLatch latch;

    CountDownThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int k = (int) (Math.random() * Integer.MAX_VALUE % 1000000);
            if (k == 666) {
                System.out.println(i);
                break;
            }
        }
        latch.countDown();
    }
}
