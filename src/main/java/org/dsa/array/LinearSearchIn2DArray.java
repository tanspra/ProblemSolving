package org.dsa.array;

import java.util.Arrays;

public class LinearSearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {23, 45, 67,}, {90, 67, 89, 34}, {123, 345}};
        int[] ans = linearSearchIn2DArray(arr, 90);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] linearSearchIn2DArray(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
