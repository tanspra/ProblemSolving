package org.dsa.leetcode.p5;

public class CeilinaSortedArray {
    public static void main(String[] args) {
        System.out.println(new CeilinaSortedArray().findCeil(new int[]{1,3,5,7}, 4));
    }
    public int findCeil(int[] arr, int x) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                ans = Math.min(ans, mid);
                right = mid - 1;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
