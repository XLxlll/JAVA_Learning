package com.company.thread_learning;

import java.util.concurrent.*;

/**
 * @title: ThreadLearning4
 * @Author Geek_Ling
 * @Date: 2020/8/13 20:09
 * @Version 1.0
 */
public class ThreadLearning4 implements Callable<Integer> {
    /**
     * @description
     * 与 实现Runnable，重写public  void  run(){}的区别
     *     * 1.重写Callable<V>，需要返回值类型
     *      * 2.重写Call()，需要抛出异常
     * @param
     * @return java.lang.Integer
     * @author Geek_Ling
     * @date 2020/8/13
     */

    @Override
    public Integer call() throws Exception {
        return 123;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadLearning4 t4 = new ThreadLearning4();
        ExecutorService service = Executors.newFixedThreadPool(3);
        Future<Integer> r1 = service.submit(t4);
        int rs1 = r1.get();
        //关闭
        service.shutdownNow();
    }

}
