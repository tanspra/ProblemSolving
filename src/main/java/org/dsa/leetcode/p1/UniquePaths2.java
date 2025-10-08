package org.dsa.leetcode.p1;

public class UniquePaths2 {
  public static void main(String[] args) {
//    int[][] obstacleGrid = {{1}};
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    System.out.println(new UniquePaths2().uniquePathsWithObstacles(obstacleGrid));
    
  }
  
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
      return 0;
    }
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    
    int[][] dp = new int[m][n];
    
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }
    
    dp[0][0] = 1;
    
    for (int i = 1; i < n; i++) {
      if (obstacleGrid[0][i] == 0) {
        dp[0][i] = dp[0][i - 1];
      }
    }
    
    for (int i = 1; i < m; i++) {
      if (obstacleGrid[i][0] == 0) {
        dp[i][0] = dp[i-1][0];
      }
    }
    
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (obstacleGrid[i][j] == 0) {
          dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
      }
    }
    
    return dp[m-1][n-1];
  }
  
  
  //Brute force approach
 /* public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
    return uniquePathFinder(obstacleGrid, 0, 0);
  }
  
  private int uniquePathFinder(int[][] obstacleGrid, int row, int col) {
    //robot reached goal square
    if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
      if (isSafe(obstacleGrid, row, col))
        return 1;
      else
        return 0;
    }
    
    if (!isSafe(obstacleGrid, row, col))
      return 0;
    
    int solution = 0;
    
    //move right
    if (isSafe(obstacleGrid, row, col + 1)) {
      solution += uniquePathFinder(obstacleGrid, row, col + 1);
    }
    
    //move down
    if (isSafe(obstacleGrid, row + 1, col)) {
      solution += uniquePathFinder(obstacleGrid, row + 1, col);
    }
    return solution;
  }
  
  private boolean isSafe(int[][] obstacleGrid, int row, int col) {
    return (row < obstacleGrid.length) && (col < obstacleGrid[0].length) && (obstacleGrid[row][col] == 0);
  }*/
}
