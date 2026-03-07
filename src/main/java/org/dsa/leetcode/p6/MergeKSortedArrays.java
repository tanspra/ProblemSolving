package org.dsa.leetcode.p6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        int[][] mat = {{1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}};
        System.out.println(Arrays.toString(new MergeKSortedArrays().mergeArrays(mat).toArray()));
    }

    public ArrayList<Integer> mergeArrays(int[][] mat) {
        // Code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                pq.offer(mat[i][j]);
            }
        }
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }
}
