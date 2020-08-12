package com.company.leetCode;

/**
 * @title: KMPLearning ---动态规划解决KMP
 * @Author Geek_Ling
 * @Date: 2020/8/12 17:17
 * @Version 1.0
 */
public class KMPLearning {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()){
            return 0;
        }
        char[] txt = haystack.toCharArray();
        char[] pat = needle.toCharArray();
        int N = txt.length;
        int M = pat.length;
        //dp[状态][字符] = 下个状态
        int[][] dp = new int[M][256];
        //当前状态是0，遇到字符pat[0],转移到下一个状态1
        dp[0][pat[0]] = 1;
        //影子状态，保证最小回退
        int X = 0;
        //构建状态转移图，从状态1开始
        for (int i = 1; i <M ; i++) {
            for (int j = 0; j <256 ; j++) {
                dp[i][j] = dp[X][j];
            }
            dp[i][pat[i]] = i+1;
            X = dp[X][pat[i]];
        }
        //pat的状态从0开始
        int k = 0;
        for (int i = 0; i < N; i++) {
            //计算pat的初始状态
            k = dp[k][txt[i]];
            if (k == M) return i-M+1;
        }
        return -1;
    }

}
