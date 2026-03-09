package org.dsa.leetcode.binarysearchalgo;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(new int[]{1}));
    }
    public int findMin(int[] nums) {
        int ans = -1;
        int n = nums.length;
        int left = 0, right = n - 1;
        int checkvalue = nums[right];
        while (left <= right) {
            int mid = left + (right - left )/2;
            if(nums[mid] < checkvalue){
                ans = mid;
                right = mid-1;
            }else if(nums[mid] > checkvalue){
                left = mid+1;
            }else{
                ans = mid;
                right = mid-1;
            }
        }
        return nums[ans];
    }
}
