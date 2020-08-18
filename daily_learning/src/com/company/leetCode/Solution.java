package com.company.leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Stack;

/**
 * @title: Solution
 * @Author Geek_Ling
 * @Date: 2020/8/3 12:37
 * @Version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        int[][] points = {{1,3},{2,4}};
        Solution solution = new Solution();
       /* System.out.println(solution.intervalSchedule(points));*/

        String str2 = ")()())";

        System.out.println(solution.longestValidParentheses(str2));
    }
    /**
     * @description 1480. Running Sum of 1d Array
     * @param nums
     * @return int[]
     * @author Geek_Ling
     * @date 2020/8/18
     */

    public int[] runningSum(int[] nums) {
        int[] preSum = new int[nums.length+1];
        for (int i = 1; i <preSum.length; i++) {
            preSum[i] +=preSum[i-1] + nums[i-1];
        }
        int[] ans = new int[nums.length];
        for (int i = 1; i < preSum.length; i++) {
            ans[i-1] = preSum[i];
        }
        return ans;
    }
  /**
   * @description 32. Longest Valid Parentheses
   * @param s
   * @return int
   * @author Geek_Ling
   * @date 2020/8/18 
   */
    
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')'){
                //如果遍历的字符是')'的话，计算dp
                if (s.charAt(i-1) == '('){
                    //s[i-1,i]-()
                    dp[i] = (i>=2?dp[i-2]:0)+2;
                }else if (i-dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == '('){
                    dp[i] = dp[i-1] +((i-dp[i-1])>=2 ? dp[i-dp[i-1]-2]:0)+2;
                }
                maxans = Math.max(maxans,dp[i]);
            }
        }
        return maxans;
    }

    /**
     * @description 452. Minimum Number of Arrows to Burst Balloons
     * 考察最多有几个不重叠区域，就至少需要几个箭头
     * 注意这里的条件中X_start <= X <= X_end,也就是说这里区间端点相同的，区间就重复了
     * @param points
     * @return int
     * @author Geek_Ling
     * @date 2020/8/3
     */

    public int findMinArrowShots(int[][] points) {
        return intervalsSchedule(points);
    }

    private int intervalsSchedule(int[][] points){
        if (points.length == 0) return 0;
        //按照end升序排列
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] -o2[1];
            }
        });
        int count = 1;
        //选择升序排列之后的第一个区间作为x
        int x_end = points[0][1];
        for (int[] point:
             points) {
            int start = point[0];
            //只有下一个的start大于x的end，在该题目下，才是不重叠的区间
            if (start > x_end){
                count ++;
                x_end = point[1];
            }
        }
        return count;
    }
    /**
     * @description 435. Non-overlapping Intervals
     * intervalSchedule -- 求解的是最多有几个区间不会重叠，
     * 那么剩下的就是至少需要除去的区间。
     * @param intervals
     * @return int
     * @author Geek_Ling
     * @date 2020/8/3
     */

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        return n - intervalSchedule(intervals);
    }
    /**
     * @description 最多有几个区间不会重叠
     * 首先要把区间集合按照end升序排列，再执行下面的
     * 1. 从区间集合 intvs 中选择⼀个区间 x，这个 x 是在当前所有区间中结束
     * 最早的（end 最⼩）。
     * 2. 把所有与 x 区间相交的区间从区间集合 intvs 中删除。
     * 3. 重复步骤 1 和 2，直到 intvs 为空为⽌。之前选出的那些 x 就是最⼤不
     * 相交⼦集。
     * @param intervals
     * @return int
     * @author Geek_Ling
     * @date 2020/8/3
     */

    public int intervalSchedule(int[][] intervals){
        if (intervals.length == 0) return 0;
        //按照end升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //至少有一个区间不相交,
        int counts = 1;
        //排序后，第一个区间就是x
        int end_x = intervals[0][1];
        /*for (int i = 1; i <intervals.length ; i++) {
            int start = intervals[i][0];

            if (start >= end_x){
                counts++;
                end_x = intervals[i][1];
            }
        }*/
        for (int[] interval:intervals) {
            int start = interval[0];
            //当前区间的start >= x区间的end的话，说明这两个区间不相交，那么不相交区间数加一，当前区间成为新的x
            if (start >= end_x){
                counts++;
                end_x = interval[1];
            }
            //如果当前区间与x区间相交，判断下一个区间
        }
        return  counts;
    }
}
