package org.dsa.leetcode.slidingwindow;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        int low = 0, high = 0;
        int sum = 0;
        while(high < n) {
            sum += nums[high];
            while(sum >= target) {
                result = Math.min(result, high - low + 1);
                sum -= nums[low++];
            }
            high++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
    public int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        int low = 0, high = 0;
        while (low <= high && high < n) {
            int sum = getSum(nums, low, high);
            if (sum >= target) {
                result = Math.min(result, high - low + 1);
                low++;
            } else {
                high++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private int getSum(int[] nums, int j, int i) {
        int sum = 0;
        for (int k = j; k <= i; k++) {
            sum += nums[k];
        }
        return sum;
    }
}
