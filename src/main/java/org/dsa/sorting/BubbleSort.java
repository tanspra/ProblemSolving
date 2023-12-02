package org.dsa.sorting;

import java.util.Arrays;

/*
 * Space complexity = O(1) -> it doesn't takes additional space to store data
 * Time complexity ,
 *   Best Case : O(N) => sorted condition
 *   Worst case : O(N^2) => Sorted in opposite order
 *
 * As the size of array is growing the no of comparison is also growing -> Time Complexity
 *
 * Stability : Bubble sort is not stable (In sense of Stability)
 * */
public class BubbleSort {
    public static int[] sort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            //If no swapped has been done, that means array is sorted
            if (!swapped) {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 3, 4, 5, 6})));
    }
}
