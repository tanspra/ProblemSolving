package org.dsa.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue=new LinkedList<>();
        int row=grid.length;
        int col=grid[0].length;
        int fresh = 0;
        int time = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty() && fresh > 0){
            time++;
            int size = queue.size();
            while(size-- > 0){
                int[] cur=queue.poll();
                int r =  cur[0];
                int c = cur[1];
                //move left
                if(isValid(grid,r,c-1) &&  grid[r][c-1]==1){
                    grid[r][c-1]=2;
                    queue.offer(new int[]{r,c-1});
                    fresh--;
                }
                //move right
                if(isValid(grid,r,c+1) &&   grid[r][c+1]==1){
                    grid[r][c+1]=2;
                    queue.offer(new int[]{r,c+1});
                    fresh--;
                }
                //move up
                if(isValid(grid,r-1,c) && grid[r-1][c]==1){
                    grid[r-1][c]=2;
                    queue.offer(new int[]{r-1,c});
                    fresh--;
                }
                //move down
                if(isValid(grid,r+1,c) && grid[r+1][c]==1){
                    grid[r+1][c]=2;
                    queue.offer(new int[]{r+1,c});
                    fresh--;
                }
            }
        }
        return fresh > 0 ? -1 : time;
    }
    private boolean isValid(int[][] grid, int row, int col){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
