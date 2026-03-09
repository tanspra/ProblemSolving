package org.dsa.leetcode.heap;

import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {
        System.out.println(new KthLargest().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public int findKthLargest(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}
