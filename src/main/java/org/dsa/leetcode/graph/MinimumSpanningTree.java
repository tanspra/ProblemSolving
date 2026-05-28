package org.dsa.leetcode.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTree {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};
        System.out.println(new MinimumSpanningTree().spanningTree(3, edges));
    }
    public int spanningTree(int V, int[][] edges) {
        List<List<Pair>> list = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int target = edges[i][1];
            int weight = edges[i][2];
            list.get(source).add(new Pair(target, weight));
            list.get(target).add(new Pair(source, weight));
        }
        int sum = 0;
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> queue = new PriorityQueue<>(
                Comparator.comparing(Pair::weight)
        );
        queue.add(new Pair(0, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int currentNode = pair.node;
            int currentWeight = pair.weight;
            if (visited[currentNode]) {
                continue;
            }
            visited[currentNode] = true;
            sum += currentWeight;
            for(Pair p : list.get(currentNode)) {
                int neighnour = p.node();
                int weight = p.weight();
                if(!visited[neighnour]) {
                    queue.add(new Pair(neighnour, weight));
                }
            }
        }
        return sum;
    }

    private record Pair(int node, int weight) {
    }
}
