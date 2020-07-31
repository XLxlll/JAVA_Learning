package com.company.thread_learning;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/***
 * Long 加synchronized --加锁，效率低
 * AtomicLong
 * LongAdder-线程数少的话，优势并不明显，
 * --内部用了分段锁（CAS），
 */
public class AtomicLearning {
    AtomicInteger count = new AtomicInteger(0);
        void m(){
            for (int i = 0; i < 10000; i++) {
                count.incrementAndGet();//count++,但是在多线程的情况下，不需要加锁

            }
        }

    public static void main(String[] args) {
        AtomicLearning atomicLearning = new AtomicLearning();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            threads.add(new Thread(atomicLearning::m,"thread-"+i));
        }
        //list遍历的lambda表达式
        threads.forEach((e)->e.start());
        threads.forEach((e)->{
            try {
                e.join();
            }catch (Exception exception){
                System.out.println(exception);
            }
        });
        System.out.println(atomicLearning.count);

    }
}
