package com.ds.str;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQuque {
    Lock lock = new ReentrantLock();
    Queue queue = null;
    int capacity;
    volatile int num = 0;
    Condition emptyQuque = lock.newCondition();
    Condition addQuque = lock.newCondition();
    Random rd = new Random(1);

    public BlockingQuque(int capacity) {
        queue = new LinkedList();
        this.capacity = capacity;
    }

    public void add(Integer obj) throws InterruptedException {
        try {
            lock.lock();

            while (queue.size() == capacity) {
                emptyQuque.await();
            }

            queue.add(obj);

            System.out.println("producer added :" + obj);
            Thread.sleep(2000);
            addQuque.signal();
        } finally {
            lock.unlock();
        }

    }


    public void remove() throws InterruptedException {
        try {
            System.out.println("enter in cons");
            lock.lock();
            while (queue.size() == 0) {
                System.out.println("enter in cons await");
                addQuque.await();
            }
            Object r = queue.remove();
            System.out.println("consumer removed :" + r);
            emptyQuque.signal();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQuque bq = new BlockingQuque(3);
        while (true) {
            Runnable consumer = () -> {
                try {
                    // System.out.println("consumer start");
                    bq.remove();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            Runnable producer = () -> {
                try {
                    //System.out.println("producer start");

                    bq.add(bq.rd.nextInt());
                    bq.num=++bq.num;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            Thread t1 = new Thread(consumer);
            Thread t2 = new Thread(producer);

            Thread t3 = new Thread(consumer);
            Thread t4 = new Thread(producer);
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t3.join();
            t4.join();
            t1.join();
            t2.join();
        }

    }


}
