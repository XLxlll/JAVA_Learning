package com.company.thread_learning;

import java.util.concurrent.TimeUnit;

/**
 * 1.保证线程可见性
 * -MESI
 * -缓存一致性协议 cpu 底层实现
 * 堆内存，每个线程的工作内存，每个线程之间如何知道堆内存中变量的变化---volatile
 * 2.禁止指令重排序（CPU指令重排序）
 * -DCL单例
 * -Double Check Lock（单例模式，双重检验）
 * -Mgr06.java
 */
public class ThreadLearning3 {
    volatile boolean  running = true;
    void m(){
        System.out.println(" m start ");
        while (running){
            //注释掉这里之后，不加volatile，打印输出的一直是 m start，释放掉之后出现m end/或者注释掉此处，加上volatile，出现m end
            /*try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        System.out.println(" m end ");
    }

    public static void main(String[] args) {
        ThreadLearning3 threadLearning3 = new ThreadLearning3();
        //lambda表达式 相当于new Thread(new Runnable(run(){m()}))
        new Thread(threadLearning3::m,"t1").start();
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadLearning3.running = false;
    }
}
