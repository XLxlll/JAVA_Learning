package com.company.thread_learning;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 创建线程2：实现Runable接口，重写run方法;
 * Runable接口接口中无start方法，需要创建Thread，使用下面的构造方法传递Runable对象，再调用start()
 * public Thread(Runnable target) {
 * init(null, target, "Thread-" + nextThreadNum(), 0);
 *     }
 * 创建线程3：使用lambda表达式
 *
 */
public class ThreadLearning2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println("implements Runnable");
        }
    }

    public static void main(String[] args) {
        new ThreadLearning2().run();
        new Thread(new ThreadLearning2()).start();
      new Thread(()->{
           System.out.println("implements Runnable main");
       }).start();

    }
}
