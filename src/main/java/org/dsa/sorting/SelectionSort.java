package org.dsa.sorting;

import java.util.Arrays;

/*
 *Time Complexity
 *      worst case : O(N^2)
 *      Best case : O(N^2)
 * */
public class SelectionSort {
    public static int[] sort(int[] arr) {
        int len = arr.length;
        int maxIndex = 0;

        while (len > 0) {
            int max = arr[0];
            for (int i = 1; i < len; i++) {

                if (arr[i] > max) {
                    max = arr[i];
                    maxIndex = i;
                }
            }
            if (len > 1) {
                swap(arr, maxIndex, len - 1);
            }
            len--;
        }
        return arr;
    }

    private static void swap(int[] arr, int maxIndex, int len) {
        int temp = arr[maxIndex];
        arr[maxIndex] = arr[len];
        arr[len] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 3, 5, 6, 4})));
    }
}
