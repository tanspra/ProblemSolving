package org.dsa.leetcode.p1;

import java.util.Arrays;

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int targetRow = -1;

        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] <= target && matrix[i][matrix[0].length - 1] >= target) {
                targetRow = i;
                break;
            }
        }
        if(targetRow == -1) return false;
        else{
            int[] array = Arrays.stream(matrix[targetRow]).toArray();
            return BinarySearch(array, target) != -1;
        }
    }

    private int BinarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
