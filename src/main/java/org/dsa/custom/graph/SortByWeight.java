package org.dsa.custom.graph;

import java.util.Comparator;

public class SortByWeight implements Comparator<Edge> {
    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.weight - o2.weight;
    }
}
