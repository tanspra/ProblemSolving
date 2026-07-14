package org.dsa.leetcode.problem;

public class BestTimeToBuyAndSellStock4 {
    public static void main(String[] args) {
        int[] prices = {2,4,1};
        System.out.println(new BestTimeToBuyAndSellStock4().maxProfit(2,prices));
    }

    int[][] dp;
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        k = 2*k;
        dp = new int[n+1][k + 1];
        helper(prices,0,k);
        return dp[0][k];
    }

    private int helper(int[] prices, int index, int k) {
        if (index == prices.length || k == 0) {
            return 0;
        }
        if(dp[index][k]!=0){
            return dp[index][k];
        }
        if (k % 2 == 1) {
            int c1 = helper(prices, index + 1, k-1) + prices[index];
            int c2 = helper(prices, index + 1, k);
            return dp[index][k] = Math.max(c1, c2);
        } else {
            int c1 = helper(prices, index + 1, k - 1) - prices[index];
            int c2 = helper(prices, index + 1, k);
            return dp[index][k] = Math.max(c1, c2);
        }
    }
}
