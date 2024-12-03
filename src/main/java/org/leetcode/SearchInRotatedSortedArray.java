package org.leetcode;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //if left side is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            //if right side is sorted
            else {
                if(target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        //if no result is found in array
        return -1;
    }

    public int searchBruteForce(int[] nums, int target) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res = i;
                break;
            }
        }
        return res;
    }
}
