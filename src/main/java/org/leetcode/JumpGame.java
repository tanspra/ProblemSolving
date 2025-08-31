package org.leetcode;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums1 = {3, 2, 1, 0, 4};
        int[] nums2 = {2, 0, 0};
        int[] nums3 = {3, 2, 1, 0, 4};
        System.out.println(new JumpGame().canJump(nums2));
    }

    public boolean canJump(int[] nums) {
        int reachable = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}
