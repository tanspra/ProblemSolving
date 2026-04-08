package org.dsa.custom.graph;

public class HasPath {
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0}};
        System.out.println(hasPath(edges, 4, 2, 0, new int[4]));
    }

    private static boolean hasPath(int[][] edges, int n, int start, int end, int[] visited) {
        if (start == end) return true;
        for (int i = 0; i < n; i++) {
            if (edges[start][i] == 1 && visited[i] == 0) {
                visited[i] = 1;
                if (hasPath(edges, n, i, end, visited)) return true;
            }
        }
        return false;
    }
}
