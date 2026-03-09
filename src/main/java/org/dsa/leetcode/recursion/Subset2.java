package org.dsa.leetcode.recursion;

import java.util.*;
import java.util.stream.Collectors;

public class Subset2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        new Subset2().subsetsWithDup(nums).stream().forEach(list -> {
            list.stream().forEach(System.out::print);
            System.out.println();
        });
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
        Collections.sort(list);
        subsetCreator(new ArrayList<Integer>(), list, result);
        List<List<Integer>> returnResult = result.stream().map(ArrayList::new).collect(Collectors.toUnmodifiableList());
        return returnResult;
    }

    public void subsetCreator(List<Integer> p, List<Integer> up, Set<List<Integer>> res) {
        // base case
        if (up.isEmpty()) {
            res.add(new ArrayList<>(p));
            return;
        }

        int first = up.get(0);
        List<Integer> rest = new ArrayList<>(up.subList(1, up.size()));

        // include the element
        p.add(first);
        subsetCreator(p, rest, res);

        // exclude the element
        p.remove(p.size() - 1);
        subsetCreator(p, rest, res);
    }
}
