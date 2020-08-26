package com.company.test;



/**
 * @title: Base
 * @Author Geek_Ling
 * @Date: 2020/8/19 19:23
 * @Version 1.0
 */
public class Base  extends Thread {
    private int x =2;

    public static void main(String[] args) throws InterruptedException {
        new Base().makeltSo();
    }
    public Base(){
        x =5 ;
        start();
    }
    public void makeltSo() throws InterruptedException {
        this.join();
        x = x-1;
        System.out.println(x);
    }
    public void run(){
        x *= 2;
    }
}
