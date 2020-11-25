package com.ds.str;

public class EvenOddTest {
   Object lock = new Object();
    public static void main(String[] args) {

        EvenOddTest o = new EvenOddTest();
        o.evenOdd();


    }

    public void evenOdd() {

        Runnable odd = () -> {
            for (int i = 1; i < 100; i = i + 2) {
                synchronized (lock) {
                    System.out.println( Thread.currentThread().getName()+" :"+ i);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                }

            }

        };
        Runnable even = () -> {
            for (int i = 2; i < 100; i = i + 2) {
                synchronized (lock) {
                    System.out.println( Thread.currentThread().getName()+" :"+ i);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }

        };

        Thread oddT1 = new Thread(odd,"odd");
        Thread evenT1 = new Thread(even,"even");
        oddT1.start();
        evenT1.start();

    }
}
