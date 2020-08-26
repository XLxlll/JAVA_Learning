package com.company.leetCode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;

/**
 * @title: SuperEggDropLearning —— 高楼扔鸡蛋
 * @Author Geek_Ling
 * @Date: 2020/8/21 9:15
 * @Version 1.0
 */
public class SuperEggDropLearning {
    public static void main(String[] args) {
        SuperEggDropLearning superEggDropLearning = new SuperEggDropLearning();
        System.out.println(superEggDropLearning.superEggDrop(1,2));
    }
    /**
     * @description 887. Super Egg Drop
     * @param K
     * @param N
     * @return int
     * @author Geek_Ling
     * @date 2020/8/21
     */

    public int superEggDrop(int K, int N) {

        return dp(K,N);
    }
    HashMap<Integer,Integer> memo = new HashMap<>();
    public int dp(int K,int N){
        if (!memo.containsKey(N*100+K)){
            int res = 0;
            //如果只有一个鸡蛋，线性遍历楼层，从1楼一层层往上
            if (K == 1){
                res = N;
            }
            //如果楼层数为0，不需要扔鸡蛋
            else  if (N == 0) {
                res = N;
            }else {
                int lo = 1,hi = N;
                while (lo + 1< hi){
                    int x = lo + (hi-lo)/2;
                    int t1 = dp(K-1,x-1);
                    int t2 = dp(K,N-x);

                    if (t1<t2){
                        //没碎
                        lo = x;
                    }else if (t1 >t2){
                        //碎了
                        hi = x;
                    }else {
                        lo = hi = x;
                    }

                }
                res = 1 + Math.min(Math.max(dp(K-1,lo-1),dp(K,N-lo)),Math.max(dp(K-1,hi-1),dp(K,N-hi)));

            }
            memo.put(N*100+K,res);
        }
        return memo.get(N*100+K);
    }
}
