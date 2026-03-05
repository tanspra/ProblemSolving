package org.dsa.leetcode.recursion;

public class MinCostPath {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 4, 1, 2},
                {2, 1, 8, 9},
                {4, 7, 8, 1},
                {3, 4, 1, 2},
                {2, 1, 8, 9},
                {4, 7, 8, 1}
        };
        long start= System.currentTimeMillis();
        System.out.println(minCostPath(matrix, 6, 4, 0, 0));
        long end = System.currentTimeMillis();
        System.out.println(end-start + "ms");
        start = System.currentTimeMillis();
        System.out.println(minCostPath2(matrix, 6, 4, 0, 0));
        end = System.currentTimeMillis();
        System.out.println(end-start + "ms");
        start = System.currentTimeMillis();
        System.out.println(minCostPathDp(matrix, 6, 4, 0, 0));
        end = System.currentTimeMillis();
        System.out.println(end-start + "ms");
    }

    public static int minCostPathDp (int[][] input, int m, int n, int i, int j){
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = input[m-1][n-1];

        //last row
        for (int k = n-2 ; k >= 0 ; k--) {
            dp[m-1][k] = input[m-1][k] + dp[m-1][k+1];
        }
        //last col
        for (int k = m-2; k >= 0 ; k--) {
            dp[k][n-1] = input[k][n-1] + dp[k+1][n-1];
        }
        //fill rest of dp
        for (int k = m-2; k >= 0 ; k--) {
            for (int l = n-2; l >= 0 ; l--) {
                dp[k][l] = Math.min(dp[k+1][l], Math.min(dp[k][l+1], dp[k+1][l+1])) + input[k][l];
            }
        }
        return dp[i][j];
    }
    public static int minCostPath2 (int[][] input, int m, int n, int i, int j){
        int[][] memo = new int[m][n];
        return minCostPathHelper(input, m, n, i, j,memo);
    }
    public static int minCostPathHelper (int[][] input, int m, int n, int i, int j, int[][] dp){
        if(i == m-1 && j == n-1){
            return input[i][j];
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        int diagDown = Integer.MAX_VALUE;
        //move right
        if(isValid(input, i, j+1)){
            right = minCostPath(input, m, n, i, j+1);
        }
        //move down
        if(isValid(input, i+1, j)){
            down = minCostPath(input, m, n, i+1, j);
        }
        //move diagonally down
        if(isValid(input, i+1, j+1)){
            diagDown = minCostPath(input, m, n, i+1, j+1);
        }
        int res = Math.min(right, Math.min(down, diagDown)) + input[i][j];
        dp[i][j] = res;
        return dp[i][j];
    }
    public static int minCostPath (int[][] input, int m, int n, int i, int j){
        if(i == m-1 && j == n-1){
            return input[i][j];
        }
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        int diagDown = Integer.MAX_VALUE;
        //move right
        if(isValid(input, i, j+1)){
            right = minCostPath(input, m, n, i, j+1);
        }
        //move down
        if(isValid(input, i+1, j)){
            down = minCostPath(input, m, n, i+1, j);
        }
        //move diagonally down
        if(isValid(input, i+1, j+1)){
            diagDown = minCostPath(input, m, n, i+1, j+1);
        }
        int res = Math.min(right, Math.min(down, diagDown)) + input[i][j];
        return res;
    }
    private static boolean isValid(int[][] matrix, int i, int j){
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }
}
