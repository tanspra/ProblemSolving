package org.dsa.custom.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int m =  grid.length;
        int n = grid[0].length;
        int[][] times = new  int[m][n];
        for(int[] time : times) {
            Arrays.fill(time, Integer.MAX_VALUE);
        }
        int[] x= new int[]{-1,1,0,0};
        int[] y= new int[]{0,0,-1,1};
        times[0][0] = grid[0][0];
        PriorityQueue<Pair> queue = new PriorityQueue<>(
                Comparator.comparing(Pair::time)
        );
        queue.offer(new Pair(0, 0, times[0][0]));
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int row = pair.row;
            int col = pair.col;
            int time = pair.time;
            for(int i = 0; i < 4; i++) {
                int r =  row + x[i];
                int c = col + y[i];
                if(valid(grid,r,c)){
                    int newTime = grid[r][c];
                    int effectiveTime = Math.max(newTime,time);
                    if(effectiveTime < times[r][c]) {
                        times[r][c] = effectiveTime;
                        queue.offer(new Pair(r, c, effectiveTime));
                    }
                }
            }
        }
        return times[m-1][n-1];
    }

    private boolean valid(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

    private record Pair(int row, int col, int time){}
}
