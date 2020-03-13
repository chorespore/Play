package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadShift {
    public static void main(String[] args) {
        ShiftDemo shiftDemo = new ShiftDemo();
        new Thread(() -> {
            for (int i = 0; i <= 10; i++) shiftDemo.loopA(i);
        }).start();

        new Thread(() -> {
            for (int i = 0; i <= 10; i++) shiftDemo.loopB(i);
        }).start();

        new Thread(() -> {
            for (int i = 0; i <= 10; i++) shiftDemo.loopC(i);
        }).start();

    }
}

class ShiftDemo {
    private int flag = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();


    public void loopA(int n) {
        lock.lock();
        if (flag != 1) {
            try {
                condition1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("A" + n);
        flag = 2;
        condition2.signal();

        lock.unlock();

    }

    public void loopB(int n) {
        lock.lock();
        if (flag != 2) {
            try {
                condition2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("B" + n);
        flag = 3;
        condition3.signal();

        lock.unlock();

    }

    public void loopC(int n) {
        lock.lock();
        if (flag != 3) {
            try {
                condition3.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("C" + n);
        System.out.println("--------------------" + n);

        flag = 1;
        condition1.signal();

        lock.unlock();

    }
}
