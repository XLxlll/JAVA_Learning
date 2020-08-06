package com.company.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 * @title: Main
 * @Author Geek_Ling
 * @Date: 2020/8/6 8:26
 * @Version 1.0
 */
public class Main {
    /*public static void main(String[] args) throws IOException {
       *//* BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        System.out.println("score1="+str[0]+",score2="+str[1]+",score3="+str[2]);*//*
        Scanner in = new Scanner(System.in);
            while (in.hasNext()){
                int a = in.nextInt();
                int b = in.nextInt();
                System.out.println(a+b);
            }
            }*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       while (in.hasNextLine()){
           String s = in.nextLine();
           String[] str = s.split(" ");
           int n = Integer.parseInt(str[0]);
           if (n == 0) break;
           int res = 0;
           for (int i = 1; i <=n; i++) {
               res += Integer.parseInt(str[i]);
           }
           System.out.println(res);
       }
        /*while (in.hasNext()){
            int a = in.nextInt();
            int b = in.nextInt();
            if (a==0 && b==0){
              break; //退出当前循环，即结束
            }else {
                System.out.println(a+b);
            }
        }*/
        /*int t = in.nextInt();
        for (int i = 0; i <t ; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a+b);
        }*/
    }

}
