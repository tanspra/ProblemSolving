package org.dsa.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphCycle {
    boolean result = false;

    public static void main(String[] args) {
        int[][] graph = new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        System.out.println(new UndirectedGraphCycle().isCycle(4, graph));
    }

    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                cycleHelper(adj, visited, -1, i);
            }
        }
        return result;
    }

    private void cycleHelper(List<List<Integer>> adj, boolean[] visited, int parent, int node) {
        visited[node] = true;
        for (int neighbour : adj.get(node)) {
            if (visited[neighbour] && neighbour != parent) {
                result = true;
            }
            if (neighbour == parent) {
                continue;
            }
            if (!visited[neighbour])
                cycleHelper(adj, visited, node, neighbour);
        }
    }
}
