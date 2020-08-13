package com.company.leetCode;

/**
 * @title: EditDistance
 * @Author Geek_Ling
 * @Date: 2020/8/13 21:29
 * @Version 1.0
 */
public class EditDistance {
    /**
     * @description
     * 72. Edit Distance
     *    Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
     *      You have the following 3 operations permitted on a word:
     *        Insert a character
     *        Delete a character
     *        Replace a character
     * @param word1
     * @param word2
     * @return int
     * @author Geek_Ling
     * @date 2020/8/13
     */

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        int n = word1.length();
        int m = word2.length();
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        //dp[i][j]表示word1[0..i]与word2[0..j]的最小编辑距离
        int[][] dp = new int[n][m];
        int i = n-1;
        int j = m-1;
        for (; i >=0; i--) {
            for (; j >=0 ; j--) {
                if (ch1[i] == ch2[j]) dp[i][j] = dp[i-1][j-1];
                //如果这两个字符不相等，那么在插入、删除、替换操作中选择操作最少的
                dp[i][j] = min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]) + 1;

            }
        }
        //若word1还有剩余.就要把剩下的删除掉
        if (i >=0) dp[i][j] = dp[i-1][j] +i;
        //若word2还有剩余.就要把剩下的全部插入到word1中
        if (j >=0) dp[i][j] = dp[i-1][j] +j;
        return dp[n-1][m-1];
    }
    private int min(int num1,int num2,int num3){
        return Math.min(num1,Math.min(num2,num3));
    }
}
