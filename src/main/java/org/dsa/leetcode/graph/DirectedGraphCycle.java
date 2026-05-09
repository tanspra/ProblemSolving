package org.dsa.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphCycle {
    boolean result = false;

    public static void main(String[] args) {
        int[][] graph = new int[][]{{0, 1}, {1, 2}, {2, 0}, {2, 3}};
        System.out.println(new DirectedGraphCycle().isCyclic(4, graph));
    }

    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        boolean[] visited = new boolean[V];
        boolean[] path = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                cycleHelper(adj, visited,path, i);
            }
        }
        return result;
    }

    private void cycleHelper(List<List<Integer>> adj, boolean[] visited, boolean[] path, int node) {
        visited[node] = true;
        path[node] = true;
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                cycleHelper(adj, visited, path, neighbour);
            } else if(path[neighbour]) {
                result = true;
            }
        }
        path[node] = false;
    }
}
