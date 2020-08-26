package com.company.test;

/**
 * @title: TestNum
 * @Author Geek_Ling
 * @Date: 2020/8/19 19:09
 * @Version 1.0
 */
public class TestNum {
    private static  Integer age;

    public static void main(String[] args) {
        /*grow(age);
        System.out.println(age);*/
        int a = 2,b= 3,k=5;
        switch (b/a){
            case 1:k++;
            case 2:k+=2;
            case 3:k+=3;
            default: k/=a;
        }
        System.out.println(k);
    }

  /*  public static void grow(int age) {
        age++;
    }*/
}
