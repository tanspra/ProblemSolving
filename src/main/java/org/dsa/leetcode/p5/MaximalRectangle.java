package org.dsa.leetcode.p5;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j] == '1'){
                    dp[i][j] = (j == 0) ? 1 : dp[i][j-1]+1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int minWidth = dp[i][j];
                if (minWidth == 0) continue;

                for (int k = i; k >= 0 ; k--) {
                    int height = (i-k+1);
                    minWidth = Math.min(minWidth, dp[k][j]);
                    maxArea = Math.max(maxArea, height * minWidth);
                }
            }
        }
        return maxArea;
    }
}
