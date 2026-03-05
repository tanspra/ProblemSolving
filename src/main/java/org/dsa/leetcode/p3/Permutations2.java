package org.dsa.leetcode.p3;

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {

    public static void main(String[] args) {
        for (List list : new Permutations2().permuteUnique(new int[]{1, 1, 3})) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(res, nums, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) list.add(n);
            if (!res.contains(list)) res.add(list);
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, i, start);
                backtrack(res, nums, start + 1);
                swap(nums, i, start);
            }
        }
    }

    private void swap(int[] nums, int i, int start) {
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
    }
}
