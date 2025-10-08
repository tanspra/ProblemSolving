package org.dsa.leetcode.p1;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    new Subsets().subsets(nums).stream().forEach(list -> {
      list.stream().forEach(ele -> System.out.print(ele + ","));
      System.out.println();
    });
  }
  
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    for (int n : nums) {
      list.add(n);
    }
    subsetCreator(new ArrayList<Integer>(), list, result);
    return result;
  }
  
  public void subsetCreator(List<Integer> p, List<Integer> up, List<List<Integer>> res) {
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
