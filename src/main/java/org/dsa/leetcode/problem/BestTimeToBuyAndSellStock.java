package org.dsa.leetcode.problem;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BestTimeToBuyAndSellStock {

//    public int maxProfit(int[] prices) {
//       int minPrice = Integer.MAX_VALUE;
//        int maxProfit = 0;
//        for(int i = 0; i < prices.length; i++){
//            if(prices[i] < minPrice){
//                minPrice = prices[i];
//            }else{
//                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
//            }
//        }
//        return maxProfit;
//    }

    private int[][] dp;

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;
        int[][] dp = new int[prices.length + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= k; i++) {
            dp[n][i] = 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = k; j > 0; j--) {
                if (j == 2) dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j - 1] - prices[i]);
                if (j == 1) dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j - 1] + prices[i]);
            }
        }
        return dp[0][k];
    }

//    public int maxProfit(int[] prices) {
//        int k = 2;
//        dp = new int[prices.length + 1][k + 1];
//        helper(prices, 0, k);
//        return dp[0][k];
//    }
//
//    private int helper(int[] prices, int index, int k) {
//        if (index == prices.length || k == 0) {
//            return 0;
//        }
//        if (dp[index][k] != 0) {
//            return dp[index][k];
//        }
//        if (k == 1) {
//            int c1 = helper(prices, index + 1, k - 1) + prices[index];
//            int c2 = helper(prices, index + 1, k);
//            dp[index][k] = Math.max(c1, c2);
//            return dp[index][k];
//        } else {
//            int c1 = helper(prices, index + 1, k - 1) - prices[index];
//            int c2 = helper(prices, index + 1, k);
//            dp[index][k] = Math.max(c1, c2);
//            return dp[index][k];
//        }
//    }
}
