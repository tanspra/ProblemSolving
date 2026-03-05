package org.dsa.leetcode.p1;

public class FindtheTownJudge {
    public int findJudge(int n, int[][] trust) {
        //build graph adjacency list
        int [][] graph = new int[n][n];
        //fill the graph
        for(int[] t : trust){
            graph[t[0]-1][t[1]-1] = 1;
        }
        //find the judge
        for (int i = 1; i <= n; i++) {
            if(findJudgehelper(graph, i))
                return i;
        }
        return -1;
    }
    private boolean findJudgehelper(int[][] graph, int label){
        int[] row = graph[label-1];
        for(int n : row){
            if(n == 1)
                return false;
        }
        for (int i = 0; i < graph.length; i++) {
            if(i != label-1 && graph[i][label-1] ==0)
                return false;
        }
        return true;
    }
}
