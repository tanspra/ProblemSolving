package org.dsa.leetcode.binarysearchalgo;

public class AllocateMinimumPages {
    public static void main(String[] args) {
//        System.out.println(new AllocateMinimumPages().findPages(new int[]{12, 34, 67, 90}, 2));
        System.out.println(new AllocateMinimumPages().findPages(new int[]{15, 10, 19, 10, 5, 18, 7}, 5));
    }

    public int findPages(int[] arr, int k) {
        int ans = -1;
        int n = arr.length;
        if (k > n)
            return -1;
        int low = Integer.MIN_VALUE, high = 0;
        for (int num : arr) {
            low = Math.max(low, num);
            high += num;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isBookAllocated(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isBookAllocated(int[] arr, int k, int guess) {
        int students = 1;
        int pages = 0;
        for (int j : arr) {
            if (pages + j <= guess) {
                pages += j;
            } else {
                students++;
                pages = j;
                if (students > k)
                    return false;
            }
        }
        return true;
    }
}
