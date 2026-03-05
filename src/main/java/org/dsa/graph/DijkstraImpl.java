package org.dsa.graph;

public class DijkstraImpl {
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0, 1, 3, 0, 0},
                {1, 0, 7, 2, 0},
                {3, 7, 0, 5, 1},
                {0, 2, 5, 0, 7},
                {0, 0, 1, 7, 0}
        };
        System.out.println("Dijkstra's Algorithm");
        dijkstra(graph, 5, 1);
    }

    private static void dijkstra(int[][] graph, int n, int source) {
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];

        for (int i = 0; i < n; i++) {
            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        for (int i = 0; i < n - 1; i++) {
            int minVertex = getMinVertex(visited, distance, n);
            visited[minVertex] = true;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && graph[minVertex][j] != 0 && distance[minVertex] + graph[minVertex][j] < distance[j]) {
                    distance[j] = distance[minVertex] + graph[minVertex][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + distance[i]);
        }
    }

    private static int getMinVertex(boolean[] visited, int[] distance, int n) {
        int minVertex = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }
}
