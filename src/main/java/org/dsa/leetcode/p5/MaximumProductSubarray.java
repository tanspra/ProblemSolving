package org.dsa.leetcode.p5;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{-2, 0, -1}));
    }

    public int maxProduct(int[] nums) {
        int res, minBest, maxBest;
        res = minBest = maxBest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int v1 = nums[i];
            int v2 = minBest * nums[i];
            int v3 = maxBest * nums[i];
            minBest = Math.min(v1, Math.min(v2, v3));
            maxBest = Math.max(v1, Math.max(v2, v3));
            res = Math.max(res, maxBest);
        }

        return res;
    }
}
