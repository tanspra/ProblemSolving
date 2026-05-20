package org.dsa.custom.graph;

import java.util.*;

public class ShortestPathInUndirectedGraph {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {0, 3},
                {1, 2},
                {3, 4},
                {4, 5},
                {2, 6},
                {5, 6},
                {6, 7},
                {6, 8},
                {7, 8}
        };
        int[] shortestPath = new ShortestPathInUndirectedGraph().shortestPath(9, edges, 0);
        System.out.println(Arrays.toString(shortestPath));
    }

    public int[] shortestPath(int V, int[][] edges, int src) {
        List<List<Integer>> graph = new ArrayList();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int source= edges[i][0];
            int destination= edges[i][1];
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }
        int[] distance = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();
        distance[src] = 0;
        queue.add(src);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;
            for(int neighbour : graph.get(cur)){
              if(!visited[neighbour]){
                  if(distance[neighbour] == -1){
                      distance[neighbour] = distance[cur] + 1;
                  }
                  queue.add(neighbour);
              }
            }
        }
        return  distance;
    }
}
