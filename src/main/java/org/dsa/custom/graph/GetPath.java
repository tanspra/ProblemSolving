package org.dsa.custom.graph;

import java.util.ArrayList;
import java.util.List;

public class GetPath {
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}};
        List<Integer> path = getPath(edges, 4, 1, 3, new boolean[4]);
        System.out.println(path);
    }

    private static List<Integer> getPath(int[][] edges, int n, int start, int end, boolean[] visited) {
        if (start == end) {
            List<Integer> path = new ArrayList<>();
            path.add(start);
            return path;
        }
        visited[start] = true;
        for (int i = 0; i < n; i++) {
            if(edges[start][i] == 1 && !visited[i]){
                List<Integer> path = getPath(edges, n, i, end, visited);
                if(path != null){
                    path.add(start);
                    return path;
                }
            }
        }
        return null;
    }
}
