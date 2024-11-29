package org.leetcode;

import java.util.Arrays;

/*
https://leetcode.com/problems/next-permutation/description/?envType=problem-list-v2&envId=array

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.



Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
* */
public class NextPermutation {
    public static void main(String[] args) {
//        new NextPermutation().nextPermutation(new int[]{1, 2, 3});
//        new NextPermutation().nextPermutation(new int[]{3, 2 ,1});
//        new NextPermutation().nextPermutation(new int[]{1,3,2});
        new NextPermutation().nextPermutation(new int[]{5,4,7,5,3,2});
    }

    public void nextPermutation(int[] nums) {

        int breakPoint = -1;
        int breakPoint1= -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                breakPoint = i;
                break;
            }
        }
        if(breakPoint == -1) {
            reverse(nums,0);
            System.out.println(Arrays.toString(nums));
        }else{
            for(int i = nums.length-1; i > breakPoint; i--) {
                if(nums[i] > nums[breakPoint]) {
                  breakPoint1= i;
                  break;
                }}
                swap(nums,breakPoint1,breakPoint);
                reverse(nums,breakPoint+1);
                System.out.println(Arrays.toString(nums));
        }
    }

    public void reverse(int[] nums, int start) {
        int length = nums.length - start;
        int end = nums.length-1;
        for(int i = 1; i <= (length/2); i++) {
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    public void reverse1(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private void swap(int[] nums, int i, int i1) {
        int temp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = temp;
    }
}
