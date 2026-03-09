package org.dsa.leetcode.heap;

import java.util.PriorityQueue;

public class KthSmallest {
    public static void main(String[] args) {
        System.out.println(new KthSmallest().kthSmallest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public int kthSmallest(int[] arr, int k) {
        // Code here

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> b-a);
        for (int i : arr) {
            pq.add(i);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}
