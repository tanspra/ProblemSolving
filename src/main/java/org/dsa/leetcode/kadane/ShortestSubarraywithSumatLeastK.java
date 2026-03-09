package org.dsa.leetcode.kadane;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestSubarraywithSumatLeastK {
    public static void main(String[] args) {
        System.out.println(new ShortestSubarraywithSumatLeastK().shortestSubarray(new int[]{2,-1,2}, 3));
        System.out.println(new ShortestSubarraywithSumatLeastK().shortestSubarray(new int[]{1}, 1));
        System.out.println(new ShortestSubarraywithSumatLeastK().shortestSubarray(new int[]{1,2}, 4));
        System.out.println(new ShortestSubarraywithSumatLeastK().shortestSubarray(new int[]{77,19,35,10,-14}, 19));
        System.out.println(new ShortestSubarraywithSumatLeastK().shortestSubarray(new int[]{17,85,93,-45,-21}, 150));
        System.out.println(new ShortestSubarraywithSumatLeastK().shortestSubarray(new int[]{56,-21,56,35,-9}, 61));
    }
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        Deque<Integer> deque = new LinkedList<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n ; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        for (int i = 0; i <= n; i++) {
            while(!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                ans = Math.min(ans, i - deque.pollFirst());
            }
            while(!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) deque.pollLast();
            deque.offerLast(i);
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}
