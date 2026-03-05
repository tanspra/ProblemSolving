package org.dsa.leetcode.p4;
/*
 * https://leetcode.com/problems/unique-paths/
 */

import java.util.Arrays;
import java.util.Set;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(4, 5));
    }

    public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return getUniquePaths(m,n,dp);
    }

    public int getUniquePaths(int m, int n, int[][] paths) {
        if (m == 1 || n == 1) {
            return 1;
        }

        if (n > 1 && m > 1) {
            if(paths[m-1][n-1] != -1){
                return paths[m-1][n-1];
            }
            int right = getUniquePaths(m, n - 1,paths);
            int down = getUniquePaths(m - 1, n,paths);
            int totalNoOfPaths = right + down;
            paths[m-1][n-1] = totalNoOfPaths;
            return totalNoOfPaths;
        }else {
            return 0;
        }
    }

    public void getUniquePaths(int row, int col, int m, int n, Set<String> set, String path) {
        // reached the goal
        if (row == m - 1 && col == n - 1) {
            set.add(path);
            return;
        }

        // move right
        if (isValidCell(row, col + 1, m, n)) {
            path += "R";
            getUniquePaths(row, col + 1, m, n, set, path);
        }
        //move down
        if (isValidCell(row + 1, col, m, n)) {
            path += "D";
            getUniquePaths(row + 1, col, m, n, set, path);
        }

    }

    public boolean isValidCell(int row, int col, int m, int n) {
        return !(row < 0 || row >= m || col < 0 || col >= n);
    }
}
