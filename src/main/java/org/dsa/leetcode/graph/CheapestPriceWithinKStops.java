package org.dsa.leetcode.graph;

import java.util.Arrays;

public class CheapestPriceWithinKStops {
    public static void main(String[] args) {
        int[][] flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        System.out.println(new CheapestPriceWithinKStops().findCheapestPrice(4, flights, 0,3,1));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       int[] distances = new int[n];
       Arrays.fill(distances,Integer.MAX_VALUE);
       distances[src] = 0;
       int[] temp = Arrays.copyOf(distances,n);
        for (int i = 0; i <= k; i++) {
            for(int[] flight : flights) {
                int source = flight[0];
                int destination = flight[1];
                int cost = flight[2];
                if(distances[source] == Integer.MAX_VALUE)
                    continue;
                if(distances[source] + cost < temp[destination]) {
                    temp[destination] = distances[source] + cost;
                }
            }
            distances = Arrays.copyOf(temp,n);
        }
       return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
    }
}
