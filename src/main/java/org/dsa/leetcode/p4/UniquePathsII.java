package org.dsa.leetcode.p4;

import java.util.Set;

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{1,0}};
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Set<String> set = new java.util.HashSet<>();
        getUniquePaths(0, 0, obstacleGrid.length, obstacleGrid[0].length, set, "", obstacleGrid);
        return set.size();
    }

    public void getUniquePaths(int row, int col, int m, int n, Set<String> set, String path, int[][] obstacleGrid) {
        // reached the goal
        if (row == m - 1 && col == n - 1) {
            if (obstacleGrid[row][col] == 0)
                set.add(path);
            return;
        }

        if(obstacleGrid[row][col] == 1) return;
        // move right
        if (isValidCell(row, col + 1, m, n, obstacleGrid)) {
            path += "R";
            getUniquePaths(row, col + 1, m, n, set, path, obstacleGrid);
        }
        //move down
        if (isValidCell(row + 1, col, m, n, obstacleGrid)) {
            path += "D";
            getUniquePaths(row + 1, col, m, n, set, path, obstacleGrid);
        }

    }

    public boolean isValidCell(int row, int col, int m, int n, int[][] obstacleGrid) {

        return !(row < 0 || row >= m || col < 0 || col >= n || obstacleGrid[row][col] == 1);
    }
}
