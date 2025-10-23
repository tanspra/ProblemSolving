package org.dsa.leetcode.p3;

/*268 : https://leetcode.com/problems/missing-number/
 *
 * */
class MissingNumber {
    public static void main(String[] args) {
        System.out.println(new MissingNumber().missingNumber(new int[]{3, 0, 1}));
    }

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int index = 0;

        while (index < len) {
            if (nums[index] != index && nums[index] != len) {
                swap(nums, index);
            } else {
                index++;
            }
        }
        int index2 = 0;
        while (index2 < len) {
            if (nums[index2] != index2) {
                return index2;
            } else {
                index2++;
            }
        }
        return len;
    }

    private void swap(int[] nums, int index) {
        int temp = nums[index];
        nums[index] = nums[temp];
        nums[temp] = temp;
    }
}