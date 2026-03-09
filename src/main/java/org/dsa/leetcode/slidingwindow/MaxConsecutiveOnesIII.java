package org.dsa.leetcode.slidingwindow;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        System.out.println(new MaxConsecutiveOnesIII().longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int result = Integer.MIN_VALUE;
        for(int high = 0; high < n; high++) {
            if(nums[high] == 0) k--;
            while(k<0){
                if(nums[low] == 0) k++;
                low++;
            }
            result = Math.max(result, high - low + 1);
        }
        return result;
    }
}
