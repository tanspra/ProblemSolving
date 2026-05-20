package org.dsa.custom.graph;

import java.util.*;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 9}};
        int[] distances = new DijkstraAlgorithm().dijkstra(2, edges, 0);
        System.out.println("distances: " + Arrays.toString(distances));
    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        int[] distances = new int[V];
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            int distance = edge[2];
            graph.get(source).add(new Pair(destination, distance));
            graph.get(destination).add(new Pair(source, distance));
        }
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.distance)
        );
        queue.add(new Pair(src, 0));
        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            int currentNode = currentPair.node;
            int currentDistance = currentPair.distance;
            if (currentDistance > distances[currentNode]) {
                continue;
            }
            for (Pair adjacentPair : graph.get(currentNode)) {
                int neighbour = adjacentPair.node;
                int edgeDistance = adjacentPair.distance;
                if (currentDistance + edgeDistance < distances[neighbour]) {
                    distances[neighbour] = currentDistance + edgeDistance;
                    queue.add(new Pair(neighbour, distances[neighbour]));
                }
            }
        }
        return distances;
    }

    private static class Pair {
        int node, distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
