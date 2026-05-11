package org.dsa.leetcode.graph;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 3},
                {2, 3},
                {4, 1},
                {4, 0},
                {5, 0},
                {5, 2}};
        ArrayList<Integer> ans = new TopologicalSort().topoSort(6, edges);
        System.out.println(Arrays.toString(ans.toArray()));
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] dependent = new int[V];
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            dependent[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if(dependent[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()) {
            int v = queue.poll();
            ans.add(v);
            for(int neighbour : graph.get(v)) {
                dependent[neighbour]--;
                if(dependent[neighbour]==0) queue.add(neighbour);
            }
        }
        return ans;
    }
}
