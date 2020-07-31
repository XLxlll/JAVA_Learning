package com.company.thread_learning;

/**
 * synchronized 关键字学习
 */
public class SynchronizedLearning {
    private int count = 10;
    private Object o = new Object();
    //1.对某个对象加锁，这个对象不能每次都new
    public void  m1(){
        synchronized(o){
            count--;
            System.out.println(Thread.currentThread().getName()  + "count = "+ count);

        }
    }
    //2.使用synchronized(this) 锁定当前对象 等价于 synchronized  void  m2()
    public synchronized  void  m2(){
        synchronized(this){
            System.out.println("this==="+this+"====SynchronizedLearning.class==="+SynchronizedLearning.class);
            count--;
            System.out.println(Thread.currentThread().getName()  + "count = "+ count);

        }
    }
    public synchronized  void  m3(){
        count--;
        System.out.println(Thread.currentThread().getName()  + "count = "+ count);
    }
    private static int count2 = 10;
    //3.synchronized static 修饰一个方法时，static 不需要创建对象synchronized(this) ，所以不能用 等价于 synchronized (SynchronizedLearning.class)，
    public synchronized static void m4(){
        //静态方法里面只能有静态变量
        count2 -- ;
        System.out.println(Thread.currentThread().getName()  + "count2 = "+ count2);
    }
    public static void m5(){
        //在同一个classLoader中，这里是单例
        synchronized (SynchronizedLearning.class){
            count2 -- ;
            System.out.println(Thread.currentThread().getName()  + "count2 = "+ count2);
        }
    }


    public static void main(String[] args) {

    }
}
