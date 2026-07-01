package org.dsa.leetcode.recursion;

public class SubsetSubProblem {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 34, 4, 12, 5, 2};
        System.out.println(isSubsetSum(arr, 9));
    }

    static Boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 1; i <=sum ; i++) {
            dp[n][i] = 0;
        }
        dp[n][0] = 1;
        for (int i = n-1; i >=0 ; i--) {
            for (int j = 0; j <=sum ; j++) {
                if(arr[i] > j){
                    dp[i][j] =  dp[i+1][j];
                }else{
                    dp[i][j] =  dp[i+1][j] | dp[i+1][j-arr[i]];
                }
            }
        }
        return dp[0][sum] == 1;
    }

//    static Boolean isSubsetSum(int[] arr, int sum) {
//        int n = arr.length;
//        boolean[][] dp = new boolean[n+1][sum+1];
//        for(int i=0;i<=n;i++){
//            dp[i][0] = true;
//        }
//        subSetSumHelper(arr, sum, 0,dp);
//        return dp[0][sum];
//    }
//
//    private static boolean subSetSumHelper(int[] arr, int sum, int index,boolean[][] dp) {
//        if(sum == 0){
//            return true;
//        }
//        if(index >= arr.length || sum < 0){
//            return false;
//        }
//        if(dp[index][sum]){
//            return true;
//        }
//        dp[index][sum] = subSetSumHelper(arr, sum-arr[index], index+1, dp) || subSetSumHelper(arr, sum, index+1, dp);
//        return dp[index][sum];
//    }

//    static Boolean isSubsetSum(int[] arr, int sum) {
//        return subSetSumHelper(arr, sum, 0);
//    }
//
//    private static boolean subSetSumHelper(int[] arr, int sum, int index) {
//      if(sum == 0){
//          return true;
//      }
//
//      if(index >= arr.length || sum < 0){
//          return false;
//      }
//      return subSetSumHelper(arr, sum-arr[index], index+1) || subSetSumHelper(arr, sum, index+1);
//    }
}
