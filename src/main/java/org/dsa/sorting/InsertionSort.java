package org.dsa.sorting;

import java.util.Arrays;

/*
 *Time Complexity
 *      worst case :O(N^2)
 *      Best case :O(N)
 *
 * Adaptive : steps get reduced as left array is sorted , no of swaps has been reduced with comparison with bubble sort.
 * Stable
 * Used for smaller value of n -> works good when array is partially sorted.
 * */
public class InsertionSort {
    public static int[] sort(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr;
        }
        for (int i = 1; i < n; i++) {

            int currIndex = i;
            int currElement = arr[currIndex];

            while (currIndex != 0 && currElement < arr[currIndex - 1]) {
                int temp = arr[currIndex - 1];
                arr[currIndex] = arr[currIndex - 1];
                arr[currIndex - 1] = currElement;
                currIndex--;
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(sort(new int[]{-20, 7, 1, 5, 8, 9})));
    }
}
