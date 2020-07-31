package com.company.thread_learning;

import java.util.concurrent.TimeUnit;

/***
 * 创建线程1.继承Thread，重写run方法
 */
public class ThreadLearning1 extends Thread {
    @Override
    public  void  run(){
        for (int i = 0;i<10;i++){
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("ThreadLearning run");
        }
    }

    public static void main(String[] args) {
        new ThreadLearning1().run();
        //new ThreadLearning().start();---加上这一句之后，run，main交替打印，原因是多线程
        for (int i = 0;i<10;i++){
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("ThreadLearning main");
        }
        SynchronizedLearning synchronizedLearning = new SynchronizedLearning();
        synchronizedLearning.m2();
    }

}
