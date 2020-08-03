package com.company.leetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @title: Solution
 * @Author Geek_Ling
 * @Date: 2020/8/3 12:37
 * @Version 1.0
 */
public class Solution {
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
        //至少有一个区间不相交
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
