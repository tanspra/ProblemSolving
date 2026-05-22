package org.dsa.custom.graph;

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = new int[][]{{1,2,1},{2,3,2},{1,3,4}};

        System.out.println(new NetworkDelayTime().networkDelayTime(times, 3,1));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int source = time[0];
            int target = time[1];
            int delayTime = time[2];
            graph.get(source - 1).add(new Pair(target - 1, delayTime));
        }
        int[] takenTimes = new int[n];
        Arrays.fill(takenTimes, Integer.MAX_VALUE);
        takenTimes[k - 1] = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>(
                Comparator.comparingInt(pair -> pair.time)
        );
        queue.add(new Pair(k - 1, 0));
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int currNode = curr.node;
            int currTime = curr.time;
            if(currTime > takenTimes[currNode]) {
                continue;
            }
            for (Pair pair : graph.get(currNode)) {
                int neighbour = pair.node;
                int neighbourTime = pair.time;
                if (currTime + neighbourTime < takenTimes[neighbour]) {
                    takenTimes[neighbour] = currTime + neighbourTime;
                    queue.add(new Pair(neighbour, takenTimes[neighbour]));
                }
            }
        }
        int maxTime = Integer.MIN_VALUE;
        for (int time : takenTimes) {
            if(time == Integer.MAX_VALUE) {
                return -1;
            }else if(time > maxTime){
                maxTime = time;
            }
        }
        return maxTime;
    }

    private static class Pair {
        int node;
        int time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
}
