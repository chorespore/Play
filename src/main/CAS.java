package main;

import juc.ChaoLock;

import java.util.concurrent.locks.Lock;

public class CAS {

    int i = 0;
    //    Lock lock = new ReentrantLock();
    Lock lock = new ChaoLock();

    public void order() {

        i++;

//        synchronized (this) {
//            i++;
//        }

//        lock.lock();
//        try {
//            i++;
//        } finally {
//            lock.unlock();
//        }
    }


    public static void main(String[] args) throws InterruptedException {

        CAS cas = new CAS();

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    cas.order();
                }
            }).start();
        }

        Thread.sleep(3000);

        System.out.println(cas.i);

    }
}
