package org.dsa.searching;

import java.util.Arrays;

public class BinarySearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };
        int target = 30;
        int[] ans = new BinarySearchIn2DArray().searchIn2DArray(arr, target);
        System.out.println(Arrays.toString(ans));
    }

    private int[] searchIn2DArray(int[][] arr, int target) {
        int row = 0, col = arr[0].length - 1;

        while (row < arr.length && col > 0) {
            int upperbound = arr[row][col];
            if (upperbound == target) {
                return new int[]{row, col};
            }
            if (upperbound < target) {
                row++;
            }
            if (upperbound > target) {
                col--;
            }
        }
        return new int[]{-1, -1};
    }
}
