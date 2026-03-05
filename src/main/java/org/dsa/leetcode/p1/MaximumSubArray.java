package org.dsa.leetcode.p1;

public class MaximumSubArray {
  public static void main(String[] args) {
    System.out.println(new MaximumSubArray().maxSubArray(new int[]{-2,-1}));
  }
  
  /*public int maxSubArray(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    if (nums.length == 1) {
      return nums[0];
    }
    for (int start = 0; start < nums.length; start++) {
      int currentSum = 0;
      for (int end = start; end < nums.length; end++) {
        currentSum += nums[end];
        maxSum = Math.max(currentSum, maxSum);
      }
    }
    return maxSum;
  }*/
  
  public int maxSubArray(int[] nums) {
    int maxSum = nums[0];
    int currentSum = 0;
    for (int start = 0; start < nums.length; start++) {
        currentSum += nums[start];
        if(currentSum > maxSum) maxSum = currentSum;
        if(currentSum < 0 ) currentSum = 0;
      
    }
    return maxSum;
  }
  
}
