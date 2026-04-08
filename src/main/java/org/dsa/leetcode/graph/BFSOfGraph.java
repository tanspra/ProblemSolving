package org.dsa.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSOfGraph {
    public ArrayList<Integer> bfsUsingQueue(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int node = queue.poll();
           if(!visited[node]){
               visited[node] = true;
               res.add(node);
               for(int neighbour : adj.get(node)){
                   if(!visited[neighbour]){
                       queue.offer(neighbour);
                   }
               }
           }
        }
        return res;
    }
}
