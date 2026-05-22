package org.dsa.custom.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int[][] heights = new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(new PathWithMinimumEffort().minimumEffortPath(heights));
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] distances = new int[m][n];
        for (int[] distance : distances) {
            Arrays.fill(distance, Integer.MAX_VALUE);
        }
        int[] x = new int[]{1,-1,0,0};
        int[] y = new int[]{0,0,-1,1};
        distances[0][0] = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>(
                Comparator.comparing(Pair::dist));
        queue.offer(new Pair(0,0,distances[0][0]));
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int row = pair.row;
            int col = pair.col;
            int dist = pair.dist;
            for(int i = 0; i < 4; i++) {
                int r = row + x[i];
                int c = col + y[i];
                if(valid(heights,r,c)){
                    int absDist = Math.abs(heights[r][c] - heights[row][col]);
                    int effort  = Math.max(absDist, dist);
                    if(effort < distances[r][c]) {
                        distances[r][c] = effort;
                        queue.offer(new Pair(r,c,effort));
                    }
                }
            }

        }
        return distances[m - 1][n - 1];
    }

    private boolean valid(int[][] distances, int r, int c) {
        return r >= 0 && r < distances.length && c >= 0 && c < distances[0].length;
    }

    private record Pair(int row, int col, int dist) {
    }
}
