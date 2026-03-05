package org.dsa.leetcode.p1;

import java.util.ArrayList;
import java.util.List;

/*https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
* Given an array nums of n integers where nums[i] is in the range [1, n], return an array of
* all the integers in the range [1, n] that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]


Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n


Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
* */
class FindAllMissingNumber {
    public static void main(String[] args) {
        System.out.println(new FindAllMissingNumber()
                .findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        int currentindex = 0;

        while (currentindex < len) {
            if (nums[currentindex] != (currentindex + 1)) {
                if (nums[currentindex] != nums[nums[currentindex] - 1]) {
                    swap(nums, currentindex);
                } else {
                    currentindex++;
                }
            } else {
                currentindex++;
            }
        }
        int currentindex1 = 0;
        while (currentindex1 < len) {
            if (nums[currentindex1] != (currentindex1 + 1)) {
                list.add(currentindex1 + 1);
            }
            currentindex1++;
        }

        return list;
    }

    private void swap(int[] nums, int val) {
        int temp = nums[nums[val] - 1];
        nums[nums[val] - 1] = nums[val];
        nums[val] = temp;
    }
}