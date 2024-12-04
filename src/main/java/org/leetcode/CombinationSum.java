package org.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public void backtrack(int[] nums, int target, List<Integer> list, List<List<Integer>> result, int start) {

        if(target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if(target < 0) return;

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, target - nums[i], list, result, i);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, new ArrayList<>(), res, 0);
        return res;
    }

  /*  public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        //get all divisibleSubset
        HashSet<List<Integer>> set = listOfDivisibleSubsets(candidates, target);

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < candidates.length; i++) {
            int secondNumber = target - candidates[i];
            if (secondNumber > 0) {
                HashSet<List<Integer>> divisibleListHashSet = listOfDivisibleSubsets(candidates, secondNumber);
                for (List<Integer> list : divisibleListHashSet) {
                    list.add(candidates[i]);
                    Collections.sort(list);
                    set.add(list);
                }

            }
        }
        res.addAll(set);
        return res;
    }

    public HashSet<List<Integer>> listOfDivisibleSubsets(int[] candidates, int target) {
        HashSet<List<Integer>> set = new HashSet<>();
        //check for divisible
        for (int num : candidates) {
            if (target % num == 0) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < target / num; i++) {
                    list.add(num);
                }
                set.add(list);
            }
        }
        return set;
  } */
}
