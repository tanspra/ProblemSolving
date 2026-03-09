package org.dsa.leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int[][] points1 = {
                {-41, 72},
                {53, 83},
                {-95, -31},
                {-61, 68},
                {32, -56},
                {16, 88},
                {-81, -48},
                {-31, 56},
                {-57, -74},
                {24, -42},
                {-59, 72},
                {-86, 40},
                {34, -85},
                {-45, 22},
                {-35, -95}
        };
        System.out.println(Arrays.deepToString(new KClosestPointToOrigin().kClosest(points1, 9)));
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    return ((b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
                }
        );
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) pq.poll();
        }
        while(!pq.isEmpty()) ans[--k] = pq.poll();
        return ans;
    }
}
