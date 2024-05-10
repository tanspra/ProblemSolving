package org.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class RemoveDupliccateFromSortedArray {

    public static void main(String[] args) {
        System.out.println(new RemoveDupliccateFromSortedArray().removeDuplicates(new int[]{1,1}));
    }

    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
