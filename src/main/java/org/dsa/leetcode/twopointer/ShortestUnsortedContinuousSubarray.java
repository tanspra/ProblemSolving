package org.dsa.leetcode.twopointer;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
    }
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if(n <= 1) return 0;
        int left = 0, right = 0;
        int maxSeen = Integer.MIN_VALUE;
        int MinSeen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(nums[i]>maxSeen){
                maxSeen = nums[i];
            }
            if(nums[i] < maxSeen){
                right = i;
            }
        }
        for (int i = n-1; i >= 0 ; i--) {
            if(nums[i]<MinSeen){
                MinSeen = nums[i];
            }
            if(nums[i] > MinSeen){
                left = i;
            }
        }
        return right-left+1;
    }
}
