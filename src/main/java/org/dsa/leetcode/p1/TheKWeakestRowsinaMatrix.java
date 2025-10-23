package org.dsa.leetcode.p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheKWeakestRowsinaMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        int[] ints = new TheKWeakestRowsinaMatrix().kWeakestRows(grid, 3);
        System.out.println(Arrays.toString(ints));
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Integer> res = new ArrayList<>();
        int[] powerArray = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            powerArray[i] = power(mat[i]);
        }
        for (int i = 0; i < k; i++) {
            int minIndex = 0;
            for (int j = 1; j < powerArray.length; j++) {
                if(powerArray[minIndex] > powerArray[j]){
                    minIndex=j;
                }
            }
            res.add(minIndex);
            powerArray[minIndex] = Integer.MAX_VALUE;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    public int power(int[] row){
        int power = 0;
        for(int i : row){
            if(i == 1 )
                power++;
        }
        return power;
    }
}
