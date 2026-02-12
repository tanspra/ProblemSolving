package org.dsa.graph;

public class PrimsAlgoImpl {
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0, 1, 7, 0, 6, 0, 0, 0},
                {1, 0, 0, 5, 0, 0, 0, 0},
                {7, 0, 0, 2, 0, 0, 0, 0},
                {0, 5, 2, 0, 0, 0, 0, 0},
                {0, 6, 0, 0, 0, 3, 9, 0},
                {0, 0, 0, 0, 3, 0, 0, 8},
                {0, 0, 0, 0, 9, 0, 0, 4},
                {0, 0, 0, 0, 0, 8, 4, 0}
        };
        prim(graph, 8);
    }

    private static void prim(int[][] graph, int n) {
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
            weight[i] = Integer.MAX_VALUE;
        }
        parent[0] = -1;
        weight[0] = 0;
        for (int i = 0; i < n; i++) {
            int minVertex = getMinVertex(weight, visited, n);
            visited[minVertex] = true;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && graph[minVertex][j] != 0 && weight[j] > graph[minVertex][j]) {
                    weight[j] = graph[minVertex][j];
                    parent[j] = minVertex;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(parent[i] < i){
                System.out.println(parent[i] + " " + i + " " + weight[i]);
            }else{
                System.out.println(i + " " + parent[i] + " " + weight[i]);
            }
        }
    }

    private static int getMinVertex(int[] weight, boolean[] visited, int n) {
        int minIndex = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && (minIndex == -1 || weight[i] < weight[minIndex])) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
