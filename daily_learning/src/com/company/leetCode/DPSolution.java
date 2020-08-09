package com.company.leetCode;

import java.util.Arrays;

/**
 * @title: DPSolution ---动态规划问题
 * @Author Geek_Ling
 * @Date: 2020/8/4 8:32
 * @Version 1.0
 */
public class DPSolution {
    public static void main(String[] args) {
        DPSolution dpSolution = new DPSolution();

    }
    /**
     * @description 516. Longest Palindromic Subsequence
     * @param s
     * @return int
     * @author Geek_Ling
     * @date 2020/8/9
     */

    public int longestPalindromeSubseq_1(String s) {
        char[] ch = s.toCharArray();
        int len = ch.length;
        //第一个参数表示起始位置的坐标，第二个参数表示长度
        int[][] lps = new int[len][len];
        //单个字符的最长回文子序列长度为1
        for (int i = 0; i < len; i++) {
            lps[i][i] = 1;
        }
        for (int i = 1; i <len ; i++) {
            for (int j = 0; j+i <len ; j++) {
                if (ch[j] == ch[i+j]){
                    lps[j][i+j] = lps[j+1][i+j-1] +2;
                }else {
                    lps[j][i+j] = Math.max(lps[j][i+j-1],lps[j+1][i+j]);
                }
            }
        }
        return lps[0][len-1];
    }
    /**
     * @description -516 Longest Palindromic Subsequence
     * 最长回文子序列
     * 思路：子序列 最值->动态规划 （
     * 1.使用一维dp数组 arr[0...i]中所求序列的长度
     * 2.使用二维dp数组[
     * 2.1涉及2个字符串/数组的子序列 dp[i][j] --arr1[0...i] arr2[0...j]中所求子序列的长度
     * 2.2涉及1个字符串/数组的子序列 dp[i][j] --arr[i...j]所求子序列的长度
     * ]
     * ）
     * @param s
     * @return int
     * @author Geek_Ling
     * @date 2020/8/9
     */

    public int longestPalindromeSubseq_2(String s) {
        char[] ch = s.toCharArray();
        int len = ch.length;
        //dp[i][j]表示ch[i..j]中最长回文子序列的长度,i<=j
        int[][] dp = new int[len][len];
        for (int i = 0; i <len ; i++) {
            for (int j = 0; j <len ; j++) {
                dp[i][j] = 0;
            }
        }
        //base case：
        //对于i>j的，不可能出现，
        //i=j的，dp[][] = 1
        //反着遍历
        for (int i = len-1; i >=0 ; i--) {
                dp[i][i] = 1;
            for (int j = i+1; j < len; j++) {

                //找状态转移方程：dp[i][j] 若ch[i] = ch[j]的话，那么ch[i+1...j-1]对应的dp[i+1][j-1]+2，
                // 否则，就应该在ch[i+1..j]和ch[i,j-1]对应的dp[][]中取最大的
                if (ch[i] == ch[j]){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        //最长的子序列肯定在arr[0...len-1]
        return dp[0][len-1];

    }
    /**
     * @description 300. Longest Increasing Subsequence --最长递增子序列
     * 解法一：动态规划 O(n^2)
     * 解法二：二分查找O(nlogn)
     * 子序列：不一定是连续的
     * 子串：一定是连续的
     * @param nums
     * @return int
     * @author Geek_Ling
     * @date 2020/8/4 
     */
    
    public int lengthOfLIS(int[] nums) {
        //1.定义dp数组--dp[i]的含义是以nums[i]这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        //先将dp数组初始化为1
        Arrays.fill(dp,1);

        for (int i = 0; i < nums.length ; i++) {
            //2.状态转移，假设前0...i-1都求解出来了，dp[i]该怎么求解
            for (int j = 0; j <i ; j++) {
                if (nums[i] > nums[j]){
                    //那当前nums[i]与该数之前的所有数比较，找到最长的子序列，如果当前nums[i]>前面序列中的nums[j],那么dp[i] = dp[j]+1，再取最大值即可
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res = 0;
        //在dp数组中查找最大值即可,注意这里不能写i<dp.length-1，如果只有一个元素的话，不会进入for循环，那样的话，就会报错
        for (int i = 0; i <dp.length ; i++) {
           res = Math.max(res,dp[i]);
        }
        return res;
    }

}
