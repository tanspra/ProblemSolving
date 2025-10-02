package org.dsa.leetcode.p4;

import java.util.Arrays;

/* https://leetcode.com/problems/3sum-closest/description/
* 16. 3Sum Closest
Medium
Topics
Companies
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.



Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).


Constraints:

3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104
* */
public class ThreeSumClosest {
    public static void main(String[] args) {
//        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
//        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{0,0,0}, 1));
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2));
    }

    public int threeSumClosest(int[] nums, int target) {
        //sort the arrays       
        Arrays.sort(nums);
        int resultSum = nums[0] + nums[1] + nums[2];
        int minDifference = Integer.MAX_VALUE;

        //now fix the first element and search other two element
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    return sum;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
                int differenceToTarget = Math.abs(sum - target);
                if (differenceToTarget < minDifference) {
                    resultSum = sum;
                    minDifference = differenceToTarget;
                }
            }

        }
        return resultSum;
    }
}
