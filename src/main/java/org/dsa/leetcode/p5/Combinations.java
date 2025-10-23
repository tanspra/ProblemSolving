package org.dsa.leetcode.p5;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> combine = new Combinations().combine(4, 2);
        System.out.println(combine);

    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(1,n, k, new ArrayList<>(), result);
        return result;
    }
    public void backTrack(int start, int end, int k, List<Integer> current , List<List<Integer>> result){
        if(current.size() == k){
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= end; i++) {
            current.add(i);
            backTrack(i+1, end,k, current, result);
            current.remove(current.size()-1);
        }
    }
}
