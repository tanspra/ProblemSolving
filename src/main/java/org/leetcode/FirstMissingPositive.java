package org.leetcode;

import java.util.Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{1}));
    }

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length+1; i++) {
            if(!binarySearch(nums, i))
                return i;
        }
        return 1;
    }

    public boolean binarySearch(int[] nums, int target) {
        int left =0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                return true;
            }
            else if(nums[mid] > target) {
                right = mid - 1;
            }

            else if(nums[mid] < target) {
                left = mid + 1;
            }
        }
        return false;
    }
}
