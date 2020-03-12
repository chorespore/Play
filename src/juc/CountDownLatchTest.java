package juc;

import util.ChaoMath;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {


    public static void main(String[] args) throws InterruptedException {
        int n = ChaoMath.getRandom(20);

        System.out.println(n + " threads");

        CountDownLatch latch = new CountDownLatch(n);

        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            new Thread(() -> {
                for (int j = 0; j < Integer.MAX_VALUE; j++) {
                    int k = (int) (Math.random() * Integer.MAX_VALUE % 1000000);
                    if (k == 666) {
                        System.out.println(j);
                        break;
                    }
                }
                latch.countDown();
            }).start();
        }
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }
}



