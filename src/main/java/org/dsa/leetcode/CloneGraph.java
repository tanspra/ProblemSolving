package org.dsa.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public static void main(String[] args) {

    }
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Map<Node,Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        if(map.containsKey(node))
            return map.get(node);
        Node clonedNode = new Node(node.val);
        map.put(node, clonedNode);
        for(Node tempNode : node.neighbors){
            clonedNode.neighbors.add(cloneGraph(tempNode));
        }
        return clonedNode;
    }
}
