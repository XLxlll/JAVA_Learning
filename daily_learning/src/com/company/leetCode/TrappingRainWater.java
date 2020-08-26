package com.company.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @title: TrappingRainWater--接雨水
 * 42.题一维数组  Trapping Rain Water
 * @Author Geek_Ling
 * @Date: 2020/8/13 14:32
 * @Version 1.0
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height ={};
        /*System.out.println(trappingRainWater.trap_V(height));
        System.out.println(trappingRainWater.trap_M(height));
        System.out.println(trappingRainWater.trap_lrPoints(height1));
        System.out.println(trappingRainWater.min(height1,4));*/
        int[][] heightMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};


        System.out.println(trappingRainWater.trapRainWater(heightMap));
    }
    /**
     * @description
     * 407. Trapping Rain Water II
     * BFS
     * @param heightMap
     * @return int
     * @author Geek_Ling
     * @date 2020/8/14
     */
    public int trapRainWater(int[][] heightMap) {
        return 0;
    }
    /**
     * @description -不能按照之前二维的思路来，二维的可以使用双指针（在一个面上）解决，但是三维的 过了41%
     * @param heightMap
     * @return int
     * @author Geek_Ling
     * @date 2020/8/26
     */

    public int trapRainWater_error(int[][] heightMap) {
        //判断二维数组是否为空
        if (heightMap == null || heightMap.length == 0 || (heightMap.length == 1 && heightMap[0].length == 0 )) return 0;
        //m*n
        int m = heightMap.length;
        int n = heightMap[0].length;
        int ans = 0;
        //遍历行
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j <n-1 ; j++) {
                int r_min = min(heightMap[i],j);
                 int c_min = min(getCol(heightMap,j),i);
                ans += Math.min(r_min,c_min) - heightMap[i][j];
            }
        }
        return ans;
    }
    //传入一个数组，和一个index，找到该index前的最大值，找到该index后的最大值，返回这两个值中最小的
    private int min(int[] arr,int index){
        int n = arr.length;
        int l_index = arr[0];
        int r_index = arr[n-1];
        for (int i = 1; i <=index ; i++)
            l_index = Math.max(l_index,arr[i]);
        for (int i = n-2; i >=index ; i--)
            r_index = Math.max(r_index,arr[i]);
        return Math.min(l_index,r_index);
    }
    //获取二维数组的col列的值
    private int[] getCol(int[][] arrs,int col){
        int m = arrs.length;
        int n = arrs[0].length;
        int[] cols = new int[m];
        for (int i = 0; i < m; i++) {
            cols[i] = arrs[i][col];
        }
        return cols;
    }

    /***
     * @description ---暴力解法
     * 时间复杂度 O(n^2)
     * 空间复杂度O(1)
     * @param height
     * @return int
     * @author Geek_Ling
     * @date 2020/8/13
     */

    public int trap_V(int[] height) {
        int n = height.length;
        int ans = 0;
        //[1,n-2]
        for (int i = 1; i < n-1; i++) {
            int l_max = 0,r_max = 0;
            //求出i右边最高的
            for (int j = i;j<n;j++)
                r_max = Math.max(r_max,height[j]);
            //求出i左边最高的
            for (int j = i; j >= 0; j--)
                l_max = Math.max(l_max,height[j]);
            ans += Math.min(l_max,r_max) - height[i];
        }
        return ans;
    }
    /**
     * @description --备忘录
     * 时间复杂度O(n);空间复杂度O(n)
     * 暴力解法存在大量重复计算
     * l_max[i]:i左边最高的柱子
     * r_max[i]：i右边最高的柱子
     * @param height
     * @return int
     * @author Geek_Ling
     * @date 2020/8/13
     */

    public int trap_M(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int ans = 0;
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        //必须要写数组为空的话怎么办，否则这里会报空指针
        l_max[0] = height[0];
        r_max[n-1] = height[n-1];

        //计算l_max
        for (int i = 1; i <n ; i++)
            l_max[i] = Math.max(l_max[i-1],height[i]);
        for (int i = n-2; i >= 0; i--)
            r_max[i] = Math.max(r_max[i+1],height[i]);

        for (int i = 1; i < n-1; i++)
            ans += Math.min(l_max[i],r_max[i]) - height[i];
        return ans;
    }
    /**
     * @description --左右指针解法
     * 左右指针向中间汇总
     * @param height
     * @return int
     * @author Geek_Ling
     * @date 2020/8/13
     */

    public int trap_lrPoints(int[] height) {
        int n = height.length;
        int ans = 0;
        if (n == 0) return ans;
        int left = 0,right = n-1;
        int l_max = height[0];
        int r_max = height[n-1];
        while (left <= right){
            //[0,left]的最大的柱子
            l_max = Math.max(l_max,height[left]);
            //[right,n-1]最大的柱子
            r_max = Math.max(r_max,height[right]);
            //ans += Math.min(l_max,r_max) - height[i]
            if (l_max <r_max){
                ans+=l_max-height[left];
                left ++ ;
            }else {
                ans +=r_max-height[right];
                right --;
            }
        }
        return ans;
    }

}
