package org.dsa.leetcode.problem;

public class BestTimeToBuyAndSellStock3 {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(new BestTimeToBuyAndSellStock3().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 4;
        int[][] dp = new int[n+1][k+1];
        for (int i = n-1; i >= 3 ; i--) {
            dp[i][1] = Math.max(dp[i+1][1], dp[i+1][0]+prices[i]);
        }
        for (int i = n-1; i >= 2 ; i--) {
            dp[i][2] = Math.max(dp[i+1][2], dp[i+1][1]-prices[i]);
        }
        for (int i = n-1; i >= 1 ; i--) {
            dp[i][3] = Math.max(dp[i+1][3], dp[i+1][2]+prices[i]);
        }
        for (int i = n-1; i >= 0 ; i--) {
            dp[i][4] = Math.max(dp[i+1][4], dp[i+1][3]-prices[i]);
        }
        return dp[0][k];
    }
  /*  int [][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 4;
        dp = new int[n+1][k+1];
        helper(prices, 0, k);
        return dp[0][k];
    }

    private int helper(int[] prices, int index, int k) {
        if (index == prices.length || k == 0) {
            return 0;
        }
        if(dp[index][k]!=0){
            return dp[index][k];
        }
        if (k == 1 || k==3) {
            int c1 = helper(prices, index + 1, k-1) + prices[index];
            int c2 = helper(prices, index + 1, k);
            return dp[index][k] = Math.max(c1, c2);
        } else {
            int c1 = helper(prices, index + 1, k - 1) - prices[index];
            int c2 = helper(prices, index + 1, k);
            return dp[index][k] = Math.max(c1, c2);
        }
    }*/

 /*   public int maxProfit(int[] prices) {
        int k = 4;
        return helper(prices, 0, k);
    }

    private int helper(int[] prices, int index, int k) {
        if (index == prices.length) {
            return 0;
        }

        if (k == 1 || k==3) {
            int c1 = helper(prices, index + 1, k-1) + prices[index];
            int c2 = helper(prices, index + 1, k);
            return Math.max(c1, c2);
        } else {
            int c1 = helper(prices, index + 1, k - 1) - prices[index];
            int c2 = helper(prices, index + 1, k);
            return Math.max(c1, c2);
        }
    }*/

//    public int maxProfit(int[] prices) {
//        int buy1 = Integer.MIN_VALUE;
//        int sell1 = 0;
//
//        int buy2 = Integer.MIN_VALUE;
//        int sell2 = 0;
//
//        for (int price : prices) {
//
//            buy1 = Math.max(buy1, -price);
//
//            sell1 = Math.max(sell1,
//                    buy1 + price);
//
//            buy2 = Math.max(buy2,
//                    sell1 - price);
//
//            sell2 = Math.max(sell2,
//                    buy2 + price);
//        }
//
//        return sell2;
//    }

    /* using recursion and memoisation
    Integer[][][] dp = null;
    public int maxProfit(int[] prices) {
        dp  = new Integer[prices.length][2][3];
        return solve(0,1,prices,2);
    }

    private int solve(int day, int canBuy, int[] prices, int maxBuy) {
        if (day == prices.length || maxBuy == 0) {
            return 0;
        }
        if(dp[day][canBuy][maxBuy] != null){
            return dp[day][canBuy][maxBuy];
        }
        int ans;
        if (canBuy == 1) {
            int buy = solve(day + 1, 0, prices, maxBuy) - prices[day];
            int wait = solve(day + 1, 1, prices, maxBuy);
            ans =  Math.max(buy, wait);
        } else {
            int sell = prices[day] + solve(day + 1, 1, prices, maxBuy-1);
            int hold = solve(day + 1, 0, prices, maxBuy);
            ans =  Math.max(sell, hold );
        }
        return dp[day][canBuy][maxBuy] = ans;
    }

     */
}
