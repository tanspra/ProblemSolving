package org.dsa.custom.graph;

import java.util.Arrays;

public class IsGraphBipartite {
    boolean result = true;

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };
        int[][] graph1 = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}};
        System.out.println(new IsGraphBipartite().isBipartite(graph));
        System.out.println(new IsGraphBipartite().isBipartite(graph1));
    }

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1)
                dfs(graph, i, 0, colors);
        }
        return result;
    }

    void dfs(int[][] graph, int node, int colour, int[] colors) {
        colors[node] = colour;
        for (int neighbor : graph[node]) {
            if (colors[neighbor] != -1 && colors[neighbor] == colour) {
                result = false;
            }
            if (colors[neighbor] == -1) {
                dfs(graph, neighbor, 1 - colour, colors);
            }

        }
    }
}
