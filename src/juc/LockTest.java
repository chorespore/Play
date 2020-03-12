package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket, "T1").start();
        new Thread(ticket, "T2").start();
        new Thread(ticket, "T3").start();
        return;
    }
}

class Ticket implements Runnable {

    Lock lock = new ReentrantLock();
    private int cnt = 100;


    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (cnt > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "-" + --cnt);
                lock.unlock();
            }
        }

    }
}

