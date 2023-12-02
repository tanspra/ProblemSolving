package org.dsa.array;

import java.util.Arrays;

public class BinarySearchIn2DSortedArray {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8,}, {9, 10, 11, 12,}, {13, 14, 15, 16}};
        //int[][] arr = {{1, 2, 3, 4}};
        for (int i = 1; i <= 20; i++) {
            //System.out.println(i);
            int target = i;
            int[] ans = new BinarySearchIn2DSortedArray().searchInSorted2DArray(arr, target);
            System.out.println(i + " position :" + Arrays.toString(ans));
        }

//        int target = 18;
//        int[] ans = new BinarySearchIn2DSortedArray().searchInSorted2DArray(arr, target);
//        System.out.println(target + " position :"+Arrays.toString(ans));
    }

    private int[] searchInSorted2DArray(int[][] arr, int target) {
        int cols = arr[0].length;
        int rows = arr.length;
        int rowStart = 0, rowEnd = rows - 1;
        int colMid = (cols - 1) / 2;
        if (rowEnd == 0) {
            return binarySearch(arr, rowEnd, 0, cols, target);
        }
        while (rowStart < (rowEnd - 1)) {

            int rowMid = (rowStart + rowEnd) / 2;
            if (arr[rowMid][colMid] == target) {
                return new int[]{rowMid, colMid};
            }
            if (arr[rowMid][colMid] < target) {
                rowStart = rowMid;
            }
            if (arr[rowMid][colMid] > target) {
                rowEnd = rowMid;
            }
        }

        //Now we have 2 rows only
        //check if target is in middle cols or not
        if (arr[rowStart][colMid] == target) {
            return new int[]{rowStart, colMid};
        }
        if (arr[rowEnd][colMid] == target) {
            return new int[]{rowEnd, colMid};
        }

        //search in first half
        if (target <= arr[rowStart][colMid - 1]) {
            return binarySearch(arr, rowStart, 0, colMid - 1, target);
        }
        //search in second half
        if (target >= arr[rowStart][colMid + 1] && target <= arr[rowStart][cols - 1]) {
            return binarySearch(arr, rowStart, colMid + 1, cols - 1, target);
        }
        //search in third half
        if (target <= arr[rowEnd][colMid - 1]) {
            return binarySearch(arr, rowEnd, 0, colMid - 1, target);
        }
        //search in fourth half
        if (target >= arr[rowEnd][colMid + 1] && target <= arr[rowEnd][cols - 1]) {
            return binarySearch(arr, rowEnd, colMid + 1, cols - 1, target);
        }
        return new int[]{-1, -1};
    }

    public int[] binarySearch(int[][] matrix, int row, int colStart, int colEnd, int target) {
        if (colEnd - colStart == 1) {
            if (matrix[row][colEnd] == target) {
                return new int[]{row, colEnd};
            }
            if (matrix[row][colStart] == target) {
                return new int[]{row, colStart};
            }
        }
        while (colStart <= colEnd) {
            int mid = (colStart + colEnd) / 2;
            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            }
            if (matrix[row][mid] < target) {
                colStart = mid;
            }
            if (matrix[row][mid] > target) {
                colEnd = mid;
            }
        }
        return new int[]{-1, -1};
    }
}
