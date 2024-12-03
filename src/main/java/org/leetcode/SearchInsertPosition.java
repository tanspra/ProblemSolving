package org.leetcode;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1,3,5,6},2));
    }
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
       return left;
    }
}
