package org.dsa.leetcode.problem;

public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(new BestTimeToBuyAndSellStock2().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }


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
