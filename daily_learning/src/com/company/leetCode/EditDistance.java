package com.company.leetCode;

/**
 * @title: EditDistance
 * @Author Geek_Ling
 * @Date: 2020/8/13 21:29
 * @Version 1.0
 */
public class EditDistance {
    public static void main(String[] args) {
        String word1 = "";
        String word2 = "r";
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance(word1,word2));
    }
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
        int n = word1.length();
        int m = word2.length();
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        //dp[i][j]表示word1[0..i]与word2[0..j]的最小编辑距离
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = i;
        for (int j = 0; j <= m ; j++)
            dp[0][j] = j;

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m; j++) {
                if (ch1[i-1] == ch2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    //如果这两个字符不相等，那么在插入、删除、替换操作中选择操作最少的
                    dp[i][j] = min(dp[i][j-1]+1,dp[i-1][j]+1,dp[i-1][j-1]+1) ;
                }


            }
        }
        return dp[n][m];
    }
    private int min(int num1,int num2,int num3){
        return Math.min(num1,Math.min(num2,num3));
    }
}
