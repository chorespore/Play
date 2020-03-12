package juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
            long end = System.currentTimeMillis();
            System.out.println(end - start + "ms");
        });

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < Integer.MAX_VALUE; j++) {
                    int k = (int) (Math.random() * Integer.MAX_VALUE % 1000000);
                    if (k == 666) {
                        System.out.println(j);
                        break;
                    }
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
