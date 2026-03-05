package org.dsa.recursion;

public class KnapSack {
    public static void main(String[] args) {
        int[] weight = new int[]{2,3,1,4};
        int[] values = new int[]{1,7,3,6};
        System.out.println(knapsack(weight,values,0,weight.length,5));
        System.out.println(knapsack2(weight,values,5));
        System.out.println(knapsack3(weight,values,5));
    }

    public static int knapsack3 (int[] weight, int[] values, int maxWeight){
        int[] wt = new int[maxWeight+1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = maxWeight; j >= weight[i]; j--) {
                wt[j]= Math.max(wt[j], values[i]+wt[j-weight[i]]);
            }
        }
        return wt[maxWeight];
    }

    public static int knapsack2 (int[] weight, int[] values, int maxWeight){
        int n = weight.length;
        int[][] memo = new int[n+1][maxWeight+1];

        //fill first row and column
        for (int i = 0; i <=n; i++) {
            memo[i][0] = 0;
        }
        for (int i = 0; i <= maxWeight; i++) {
            memo[0][i] = 0;
        }

        //fill rest dp
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= maxWeight ; j++) {
                if(weight[i-1] <= j){
                    memo[i][j]= Math.max(memo[i-1][j], values[i-1]+memo[i-1][j-weight[i-1]]);
                }else{
                    memo[i][j] = memo[i-1][j];
                }
            }
        }
        return memo[n][maxWeight];
    }
    public static int knapsack (int[] weight, int[] values,int i, int n, int maxWeight){
        if(i == n || maxWeight == 0){
            return 0;
        }
        if(weight[i] <= maxWeight){
            return Math.max(values[i] + knapsack(weight,values,i+1,n,maxWeight-weight[i]), knapsack(weight,values,i+1,n,maxWeight));
        }else{
            return knapsack(weight,values,i+1,n,maxWeight);
        }
    }
}
