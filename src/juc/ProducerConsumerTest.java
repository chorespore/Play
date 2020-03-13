package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerTest {

    public static void main(String[] args) {

    }
}

class Clerk {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void get() throws InterruptedException {
        lock.lock();

        condition.await();

        condition.signalAll();

        lock.unlock();
    }
}
