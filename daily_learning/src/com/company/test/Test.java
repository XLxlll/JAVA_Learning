package com.company.test;

import java.util.Scanner;
import java.util.Stack;

/**
 * @title: Test
 * @Author Geek_Ling
 * @Date: 2020/8/5 19:13
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       while (true){
           String s = in.nextLine();
           String[] strs = s.split(" ");
           String str1 = strs[0];
           Stack<Integer> stack1 = new Stack<Integer>();
           Stack<String> stack2 = new Stack<String>();
           int n = helper(str1);
           for (int i = 1; i < strs.length; i++) {
               int m = helper(strs[i]);
               int ret = Math.abs(m-n);
               if (stack1.empty() || ret <=stack1.peek()){
                   stack1.push(ret);
                   stack2.push(strs[i]);
               }
           }
           System.out.println(stack2.pop());
       }
    }

    private static int helper(String str){
        int res = 0;
        char[] strs = str.toCharArray();
        for (char ch: strs) {
            if (ch >='a' && ch<='z'){
                res += ch -'a'+1;
            }else {
                res += ch -'A'+1;
            }
        }
        return res;
    }

}
