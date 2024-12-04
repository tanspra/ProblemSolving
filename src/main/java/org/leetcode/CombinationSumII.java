package org.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        System.out.println(new CombinationSumII().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, new ArrayList<>(), res, 0);
        return res;
    }

    public void backtrack(int[] nums, int target, List<Integer> list, List<List<Integer>> result, int start) {

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }

            if (nums[i] > target) {
                break;
            }
            list.add(nums[i]);
            backtrack(nums, target - nums[i], list, result, i+1);
            list.remove(list.size() - 1);
        }
    }
}
