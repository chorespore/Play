package juc;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    public static void main(String[] args) {
        RWLock rwLock = new RWLock();


        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                rwLock.get();
            }, "T" + i).start();
        }

        new Thread(() -> {
            rwLock.set(8888);
        }, "Write").start();

        System.out.println("OK");
    }

}

class RWLock {
    private int num = 0;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void get() {
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + ":" + num);
        lock.readLock().unlock();
    }

    public void set(int n) {
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName());
        this.num = n;
        lock.writeLock().unlock();
    }

}
