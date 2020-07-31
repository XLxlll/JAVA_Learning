package com.company.thread_learning;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantlock用于替代sychronized（自动解锁，非公平锁）
 *   ReentrantLock lock = new ReentrantLock([true]);默认是false
 *   --加true的话是公平锁[并不是完全公平]；公平锁与非公平锁的区别是，新来的线程先检查等待队列是否为空，若队列为空，才去抢占资源
 *        try {
 *            lock.lock();
 *        }catch (Exception e){}finally {
 *            lock.unlock();
 *        }
 *        lock.tryLock(); --尝试锁定，不管锁定与否，方法都讲继续执行
 *        根据tryLock的返回值来进行判定，也可根据设定的时间
 */
public class ReentrantLockLearning {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
       try {
           lock.lock();
       }catch (Exception e){}finally {
           lock.unlock();
       }
        try {
            lock.lockInterruptibly(); //对interrupt()方法做出响应
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
