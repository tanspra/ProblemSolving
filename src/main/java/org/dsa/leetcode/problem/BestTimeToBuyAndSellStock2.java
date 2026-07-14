package org.dsa.leetcode.problem;

public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new BestTimeToBuyAndSellStock2().maxProfit(prices));
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
                if (j == 1) dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1] + prices[i]);
            }
        }
        return dp[0][k];
    }

   /* private int[][] dp;
    public int maxProfit(int[] prices) {
        int k = 2;
        dp = new int[prices.length+1][k+1];
         helper(prices, 0, k);
         return dp[0][k];
    }

    private int helper(int[] prices, int index, int k) {
        if (index == prices.length) {
            return 0;
        }
        if (dp[index][k] != 0) {
            return dp[index][k];
        }
        if (k == 1) {
            int c1 = helper(prices, index + 1, 2) + prices[index];
            int c2 = helper(prices, index + 1, k);
            dp[index][k] = Math.max(c1, c2);
            return dp[index][k];
        } else {
            int c1 = helper(prices, index + 1, k - 1) - prices[index];
            int c2 = helper(prices, index + 1, k);
            dp[index][k] = Math.max(c1, c2);
            return dp[index][k];
        }
    }*/

//    public int maxProfit(int[] prices) {
//        int k = 2;
//        return helper(prices, 0, k);
//    }
//
//    private int helper(int[] prices, int index, int k) {
//        if (index == prices.length) {
//            return 0;
//        }
//
//        if (k == 1) {
//            int c1 = helper(prices, index + 1, 2) + prices[index];
//            int c2 = helper(prices, index + 1, k);
//            return Math.max(c1, c2);
//        } else {
//            int c1 = helper(prices, index + 1, k - 1) - prices[index];
//            int c2 = helper(prices, index + 1, k);
//            return Math.max(c1, c2);
//        }
//    }

//    public int maxProfit(int[] prices) {
//        int k = 2;
//        return helper(prices, 0, k);
//    }
//
//    private int helper(int[] prices, int index, int k) {
//        if (index == prices.length) {
//            return 0;
//        }
//
//        if (k == 1) {
//            int c1 = helper(prices, index + 1, 2) + prices[index];
//            int c2 = helper(prices, index + 1, k);
//            return Math.max(c1, c2);
//        } else {
//            int c1 = helper(prices, index + 1, k - 1) - prices[index];
//            int c2 = helper(prices, index + 1, k);
//            return Math.max(c1, c2);
//        }
//    }



    /*
      //using recursion
      public int maxProfit(int[] prices) {
              return solve(0,true,prices);
          }
     
          private int solve(int day, boolean canBuy, int[] prices) {
              if(day == prices.length){
                  return 0;
              }
              if(canBuy){
                  return Math.max(solve(day+1,false,prices) - prices[day], solve(day+1,true,prices));
              }else{
                  return Math.max(prices[day]+solve(day+1,true,prices), solve(day+1,false,prices));
              }
          }
          */
}
