package org.dsa.leetcode.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSOfGraph {
    public ArrayList<Integer> dfsUsingStack(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                res.add(node);
                visited[node] = true;
                List<Integer> neighbors = adj.get(node);
                for (int j = neighbors.size() - 1; j >= 0; j--) {
                    int neighbor = neighbors.get(j);
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return res;
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
       ArrayList<Integer> res = new ArrayList<>();
       dfsHelper(adj, res, visited, 0);
       return res;
    }
    void dfsHelper(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res, boolean[] visited, int node) {
        if(visited[node])
            return;
        res.add(node);
        visited[node] = true;
        for(int neighbor : adj.get(node)) {
            if(!visited[neighbor]) {
                dfsHelper(adj, res, visited, neighbor);
            }
        }
    }
}
