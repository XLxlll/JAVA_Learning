package com.company.leetCode;

import java.util.Arrays;

/**
 * @title: PrimesLearning
 * @Author Geek_Ling
 * @Date: 2020/8/8 16:19
 * @Version 1.0
 */
public class PrimesLearning {
    public static void main(String[] args) {
        PrimesLearning primesLearning = new PrimesLearning();
        System.out.println(primesLearning.countPrimes(3));
    }
    /***
     * @description  如何高效地计算[2,n]之间有多少个素数
     * 素数最小是2
     * 1.判断一个数是否是素数的话，i不需要遍历到n只需要遍历到sqrt(n)即可，
     * n=a*b，在到达sqrt(n)时，就会出现n = b*a
     * 2.若一个数是素数，那么它的整数倍就不是素数了
     * 时间复杂度-O(N * loglogN)，
     * @param n
     * @return int
     * @author Geek_Ling
     * @date 2020/8/8
     */

    public int countPrimes(int n){
        //定义N个长度的数组，并初始化为true
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes,true);
        int counts = 0;
        //因子对称性，只需要遍历到[2,sqrt(n)]
        for (int i = 2; i*i <n ; i++) {
            if (isPrimes[i]){
                //如果i是素数，那么i的倍数就不再是素数了
                //为什么不是从2*i开始遍历呢？因为 若i=4，那么2*4=8,已经被i=2,标记过了
                for (int j = i*i; j <n ; j+=i) {
                    isPrimes[j] = false;
                }
            }
        }
        for (int i = 2; i <n ; i++) {
            if (isPrimes[i]) counts++;
        }
        return  counts;
    }
}
