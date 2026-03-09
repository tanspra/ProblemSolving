package org.dsa.leetcode.prefixsum;

public class FindPivotIndex {
    public static void main(String[] args) {
//        int[] nums = {1, 7, 3, 6, 5, 6};
        int[] nums = {-1,-1,0,0,-1,-1};
        System.out.println(new FindPivotIndex().pivotIndex(nums));
    }
    public int pivotIndex(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int[] suffixSum = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if(prefixSum[i] == suffixSum[i]) return i;
        }
        return -1;
    }
}
