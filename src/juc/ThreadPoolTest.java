package juc;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        Future<Integer> future = pool.submit(() -> {
            int sum = 0;
            for (int i = 0; i <= 100; i++) {
                sum += i;
            }
            return sum;
        });

        int res = future.get();

        System.out.println(res);

        pool.shutdown();
    }
}


