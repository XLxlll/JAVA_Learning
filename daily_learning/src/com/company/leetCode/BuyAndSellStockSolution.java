package com.company.leetCode;

import java.awt.datatransfer.FlavorEvent;

/**
 * @title: BuyAndSellStockSolution --团灭股票问题
 * @Author Geek_Ling
 * @Date: 2020/8/5 10:07
 * @Version 1.0
 */
public class BuyAndSellStockSolution {
    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        BuyAndSellStockSolution buyAndSellStockSolution = new BuyAndSellStockSolution();
       /* System.out.println(buyAndSellStockSolution.maxProfit(prices));*/
        System.out.println(" main "+buyAndSellStockSolution.maxProfit(prices,2));
    }
    /**
     * @description
     * @param prices
     * @return int
     * @author Geek_Ling
     * @date 2020/8/10
     */

    public int maxProfit_k(int[] prices){
        int dp_i_0 = 0,dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length ; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0,dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1,temp-prices[i]);
        }
        return dp_i_0;
    }
    /**
     * @description 14. Best Time to Buy and Sell Stock with Transaction Fee
     * @param prices
     * @param fee  一次交易费用
     * @return int
     * @author Geek_Ling
     * @date 2020/8/10 
     */
    
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) return 0;
        int dp_i_0 = 0,dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i <prices.length ; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0,dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1,temp - prices[i] - fee);

        }
        return dp_i_0;
    }
    /**
     * @description 309. Best Time to Buy and Sell Stock with Cooldown
     * @param prices
     * @return int
     * @author Geek_Ling
     * @date 2020/8/10
     */

    public int maxProfit_cooldown(int[] prices) {
        if (prices.length == 0) return  0 ;
        int dp_i_0 = 0,dp_i_1 = Integer.MIN_VALUE,dp_pre_0 = 0;
        for (int i = 0; i <prices.length ; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0,dp_i_1+prices[i]);
            //卖出后需要冷冻一天才可以买入
            dp_i_1 = Math.max(dp_i_1,dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }
    /** 121. Best Time to Buy and Sell Stock
     * K = 1
     * @description -
     * @param prices
     * @return int
     * @author Geek_Ling
     * @date 2020/8/5
     */

    public int maxProfit_1(int[] prices) {
        if (prices.length == 0) return 0;
        int dp_i_0 = 0,dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length ; i++) {
            dp_i_0 = Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1 = Math.max(dp_i_0 - prices[i],dp_i_1);
        }
        return dp_i_0;
    }
    /**
     * @description 188. Best Time to Buy and Sell Stock IV
     * 最多完成k次交易，当k特别大的时候，内存溢出，考虑k的次数
     * @param k
     * @param prices
     * @return int
     * @author Geek_Ling
     * @date 2020/8/5
     */

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        int N = prices.length;
        if (k > N/2){
            //一次交易由买入和卖出构成，有效的限制k应该不超过N/2，如果超过了,就没与约束，相等于k可以取任意次数
            return maxProfit_k(prices);
        }
        int K = k+1;
        int S = 2;
        int[][][] dp = new int[N][K][S];
        for (int i = 0; i <N ; i++) {
            for (int j = k ; j >=1; j--) {

                if (i-1 == -1){
                    if (j -1 == -1){
                        //交易次数为0
                        dp[i][j][0]=0;
                        dp[i][j][1]=Integer.MIN_VALUE;
                    }else {
                        dp[i][j][0]= 0;
                        dp[i][j][1]= -prices[i];
                    }
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j-1][0]-prices[i],dp[i-1][j][1]);
            }
        }
        return dp[N-1][k][0];
    }

    /**
     * @description 123. Best Time to Buy and Sell Stock III
     * 这里的k=2
     * @param prices
     * @return int
     * @author Geek_Ling
     * @date 2020/8/5
     */

    public int maxProfit_2(int[] prices) {
        if (prices.length == 0) return 0;
        int N = prices.length;
        int K = 3;//[0,1,2]
        int S = 2;//1 持有，2不持有
        //dp[i][k][0]--在第i天，不持有股票，允许交易k次；dp[i][k][1]--在第i天，持有股票，允许交易k次；
        int[][][] dp = new int[N][K][S];
        for (int i = 0; i < N; i++) {
                for (int k = K-1; k >=1; k--) {
                    //base case
                    if (i-1 == -1){
                        if (k-1 == -1){
                            dp[i][k][0]=0;
                            dp[i][k][1]=Integer.MIN_VALUE;
                        }else {
                            dp[i][k][0]= 0;
                            dp[i][k][1]=-prices[i];
                        }
                       continue;
                    }

                    //买卖不能同时进行，同一时间只能进行一次交易，所以k值得变化方法买卖哪一次都可,但是测试只能在买的时候k-1
                    dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                    dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
                }


        }
        return dp[N-1][K-1][0];
    }
}
