package org.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*https://leetcode.com/problems/4sum/description/
18. 4Sum
Medium
Topics
Companies
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.



Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]


Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
* */
public class FourSum {
    public static void main(String[] args) {
        System.out.println(new FourSum().fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to simplify the solution
        int n = nums.length;
        for (int i = 0; i < n; i++) {
////remove duplicates
//            if (i > 1 && nums[i] == nums[i - 1]) {
//                continue; //avoid duplicate in quadruplets
//            }
            for (int j = i + 1; j < n; j++) {

//                //remove duplicates
//                if (j > (i + 1) && nums[j] == nums[j - 1]) {
//                    continue; //avoid duplicate in quadruplets
//                }


                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }


            }
        }
        return result;
    }
}
