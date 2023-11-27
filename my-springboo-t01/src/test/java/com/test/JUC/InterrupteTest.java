package com.test.JUC;

import org.hibernate.annotations.Synchronize;

import java.util.concurrent.TimeUnit;

public class InterrupteTest {
    public static void main(String[] args) {

        Thread t1 = new Thread(() ->
        {
            while (true) {
                System.out.println("............");
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + Thread.currentThread().isInterrupted());
                    break;
                }
                try {
                    Thread.sleep(200L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "_线程持续打印。。。。。。");
            }

        }, "t1");

        t1.start();
        try {
            Thread.sleep(2000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        t1.interrupt();
//        new Thread(() -> {
//            System.out.println("t2将t1标记为中断");
//            t1.interrupt();
//
//        }, "t2").start();

//     Object o = new Object();
//     o.wait();
//     o.notify();
//     o.notifyAll();

    }
}
