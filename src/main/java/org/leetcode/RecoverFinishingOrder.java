package org.leetcode;

import java.util.Arrays;

public class RecoverFinishingOrder {
    public static void main(String[] args) {
        int[] order = {3,1,2,5,4};
        int[] friends = {1,3,4};
        int[] res = new RecoverFinishingOrder().recoverOrder(order, friends);
        System.out.println(Arrays.toString(res));
    }
    public int[] recoverOrder(int[] order, int[] friends) {
        int[] result = new int[friends.length];
        int index = 0;
        for (int i = 0; i < order.length; i++) {
            if (binarySearch(friends, order[i])) {
                result[index] = order[i];
                index++;
            }
        }
        return result;
    }

    private boolean binarySearch(int[] arr, int val) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == val) {
                return true;
            } else if (val < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
