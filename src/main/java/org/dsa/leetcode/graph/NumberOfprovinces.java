package org.dsa.leetcode.graph;

public class NumberOfprovinces {
    public int findCircleNum(int[][] isConnected) {
        int numberOfProvinces = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if(!visited[i]){
                numberOfProvinces++;
                traverse(i,isConnected, visited);
            }
        }
        return numberOfProvinces;
    }
    private void traverse(int i,int[][] isConnected, boolean[] visited){
        visited[i]=true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j] == 1 && !visited[j]){
                traverse(j,isConnected,visited);
            }
        }
    }
}
