package org.dsa.searching;

public class MaximumValueIn2Darray {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {23, 45, 67,}, {90, 67, 89, 34}, {123, 345}};
        int ans = maxValueIn2DArray(arr);
        System.out.println(ans);
    }

    private static int maxValueIn2DArray(int[][] arr) {
        int max = arr[0][0];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] > max) {
                    max = arr[row][col];
                }
            }
        }
        return max;
    }
}
