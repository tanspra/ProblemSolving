package org.dsa.leetcode.p5;

public class MaximumSumCircularSubarray {
    public static void main(String[] args) {
//        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(new int[]{5,-3,5}));
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(new int[]{-3,-2,-3}));
    }

    public int maxSubarraySumCircular(int[] nums) {
       int ans = nums[0];
       int maxBest = nums[0];
       for (int i = 1; i < nums.length; i++) {
           maxBest = Math.max(nums[i], maxBest + nums[i]);
           ans = Math.max(ans, maxBest);
       }
       int res = nums[0];
       int minBest = nums[0];
       for (int i = 1; i < nums.length; i++) {
           minBest = Math.min(nums[i], minBest + nums[i]);
           res = Math.min(res, minBest);
       }
       int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        res = sum - res;
        if(res == 0)
            return ans;
       return Math.max(ans, res);
    }
}
