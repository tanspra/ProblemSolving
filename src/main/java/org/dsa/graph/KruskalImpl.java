package org.dsa.graph;

import java.util.Arrays;

public class KruskalImpl {

    public static void main(String[] args) {
        Edge[] input = new Edge[]{
                new Edge(0, 1, 1),
                new Edge(2, 3, 2),
                new Edge(4, 5, 3),
                new Edge(6, 7, 4),
                new Edge(1, 3, 5),
                new Edge(1, 4, 6),
                new Edge(0, 2, 7),
                new Edge(5, 7, 8),
                new Edge(4, 6, 9),
                new Edge(0, 3, 3)
        };
        kruskal(input, 8);
    }
    private static int findParent(int[] parent, int vertex){
        if(parent[vertex] == vertex){
            return vertex;
        }
        return findParent(parent, parent[vertex]);
    }
   private static void kruskal(Edge[] input, int n){
       Arrays.sort(input, new SortByWeight());
       Edge[] result = new Edge[n-1];
       int[] parent = new int[n];
       for(int i = 0; i < n; i++){
           parent[i] = i;
       }
       int count = 0;
       int i = 0;
       while(count != n-1){
           Edge currentEdge  = input[i];
           int sourceParent = findParent(parent, currentEdge.source);
           int destParent = findParent(parent, currentEdge.dest);
           if(sourceParent != destParent){
               result[count++] = currentEdge;
               parent[destParent] = sourceParent;
           }
           i++;
       }
       for (int j = 0; j < n-1; j++) {
           if(result[j].source < result[j].dest){
               System.out.println(result[j].source + " " + result[j].dest + " " + result[j].weight);
           }else{
               System.out.println(result[j].dest + " " + result[j].source + " " + result[j].weight);
           }
       }
    }
}
