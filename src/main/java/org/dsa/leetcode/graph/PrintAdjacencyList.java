package org.dsa.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class PrintAdjacencyList {
    public static void main(String[] args) {

    }
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            res.add(new ArrayList<>());
        }
        for(int[] arr:  edges){
            int u = arr[0];
            int v = arr[1];
            res.get(u).add(v);
            res.get(v).add(u);
        }
        return res;
    }
}
