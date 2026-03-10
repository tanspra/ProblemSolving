package org.dsa.leetcode.twopointer;

import java.util.Arrays;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        System.out.println(new SubarrayProductLessThanK().numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int left = 0;
        int product = 1;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}
