package com.company.leetCode;

import java.util.HashMap;

/**
 * @title: PreSum ---前缀和技巧
 * 1.求和为k的子数组有几个
 * 2.求和为k的子数组起始位置
 * 3.求和为k的子数组中，长度最短的起始位置---是否考虑用dp
 * @Author Geek_Ling
 * @Date: 2020/8/13 9:47
 * @Version 1.0
 */
public class PreSum {

    /**
     * @description 560. Subarray Sum Equals K
     * Given an array of integers and an integer k,
     * you need to find the total number of 【continuous subarrays】whose sum equals to k.
     * @param nums
     * @param k
     * @return int
     * @author Geek_Ling
     * @date 2020/8/19
     */
    //1.看双层for循环里面，preSum[i] - preSum[j] = k
    // 改写为preSum[j] = preSum[i] - k,只需要知道perSum数组中有几个preSum[j]即可了
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        //将前缀和及其出现的次数放入map集合
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum0_i = 0;
        for (int i = 0; i < nums.length; i++) {
            sum0_i += nums[i];
            //想要找的前缀和[0...j]
            int sum0_j = sum0_i - k;
            //如果map中有sum_j，那么找到一个符合要求的sum_j
            if (map.containsKey(sum0_j))
                ans += map.getOrDefault(sum0_j,0) ;

            //把前缀和[0...i]的加入map中
            map.put(sum0_i,map.getOrDefault(sum0_i,0)+1);
        }
        return ans;
    }

    //2.时间复杂度为O(n^2),空间复杂度为O(n)
    public int subarraySum_preSum1(int[] nums, int k) {
        //题目中给出长度在[1,20000]，不需要考虑0的问题
        int[] preSum = new int[nums.length+1];
        preSum[0] = 0;
        //计算前缀和
        for (int i = 0; i <nums.length ; i++) {
            preSum[i+1] =preSum[i] + nums[i];
        }
        int ans = 0;
        for (int i = 1; i <preSum.length ; i++) {
            for (int j = 0; j <i ; j++) {
                if (preSum[i] - preSum[j] == k){
                    ans++;
                }
            }
        }
        return ans;
    }

}
