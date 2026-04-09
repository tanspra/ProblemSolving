package org.dsa.leetcode.graph;

public class NumberOfIslands {
    public static void main(String[] args) {
//        char[][] grid = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        char[][] grid = new char[][]{{'1','0','1','1','1'},{'1','0','1','0','1'},{'1','1','1','0','1'}};
        System.out.println(new NumberOfIslands().numIslands(grid));
    }
    public int numIslands(char[][] grid) {
        int numberofislands = 0;
        boolean[][]  visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    numberofislands++;
                    buildIslands(grid, visited, i, j);
                }
            }
        }
        return numberofislands;
    }
    private void buildIslands(char[][] grid, boolean[][] visited, int i, int j){
        visited[i][j] = true;
        if(j+1 < grid[0].length && grid[i][j+1] == '1' &&  !visited[i][j+1]){
            buildIslands(grid, visited, i, j+1);
        }
        if(i+1 < grid.length && grid[i+1][j] == '1' &&  !visited[i+1][j]){
            buildIslands(grid, visited, i+1, j);
        }
        if(j-1 >= 0 && grid[i][j-1] == '1' &&  !visited[i][j-1]){
            buildIslands(grid, visited, i, j-1);
        }
        if(i-1 >= 0 && grid[i-1][j] == '1' &&  !visited[i-1][j]){
            buildIslands(grid, visited, i-1, j);
        }
    }
}
