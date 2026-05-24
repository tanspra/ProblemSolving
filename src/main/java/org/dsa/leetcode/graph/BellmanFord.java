package org.dsa.leetcode.graph;

import java.util.Arrays;

public class BellmanFord {
    public static void main(String[] args) {
        int[][] edges = {
                {1, 0, 5},
                {1, 3, 9},
                {2, 3, 5},
                {3, 0, 7},
                {3, 1, 7},
                {3, 2, 10},
                {8, 7, -9}
        };
        int[] distances = new BellmanFord().bellmanFord(9, edges, 1);
        System.out.println(Arrays.toString(distances));
    }

    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] distances = new int[V];
        Arrays.fill(distances, (int) Math.pow(10,8));
        distances[src] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int source = edge[0];
                int destination = edge[1];
                int dist = edge[2];
                if (distances[source] == (int) Math.pow(10,8)) {
                    continue;
                }
                if (distances[source] + dist < distances[destination]) {
                    distances[destination] = distances[source] + dist;
                }
            }
        }
        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            int dist = edge[2];
            if (distances[source] == (int) Math.pow(10,8)) {
                continue;
            }
            if (distances[source] + dist < distances[destination]) {
               return new int[]{-1};
            }
        }
        return distances;
    }
}
