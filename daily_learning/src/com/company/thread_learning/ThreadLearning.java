package com.company.thread_learning;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLearning implements Runnable {


    private  int count = 100;
    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName()  + "count = "+ count);
    }

    public static void main(String[] args) {
        AtomicInteger count1 = new AtomicInteger(1);
        count1.incrementAndGet();//相当于count++,原子操作
        ThreadLearning t = new ThreadLearning();
        for (int i = 0; i < 100; i++) {
            new Thread(t,"Head"+i).start();
        }
    }
}
