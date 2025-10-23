package org.dsa.leetcode.p1;

class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
    this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum =0;
        int n = nums.length;
        if( n == 0)
            return sum;
        if(left < n && right < n && left <= right){
            while(left<= right){
                sum += nums[left];
                left++;
            }
        }
        return sum;
    }
}