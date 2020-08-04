package com.company.leetCode;

import java.util.Arrays;

/**
 * @title: DPSolution ---动态规划问题
 * @Author Geek_Ling
 * @Date: 2020/8/4 8:32
 * @Version 1.0
 */
public class DPSolution {
    /**
     * @description 300. Longest Increasing Subsequence
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
