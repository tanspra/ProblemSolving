package org.dsa.leetcode.tree;


import org.dsa.util.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode2 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node result = new PopulatingNextRightPointersinEachNode2().connect(root);
        System.out.println(result.val);
    }

    public Node connect(Node root) {
        if(root == null) return root;
       Queue<Node> queue = new LinkedList<>();
       queue.add(root);
       while(!queue.isEmpty()){
           int size = queue.size();
           Node prev = null;
           for(int i=0; i<size; i++){
               Node node = queue.poll();
               if(prev!=null) prev.next = node;
               if(node.left != null) queue.add(node.left);
               if(node.right != null) queue.add(node.right);
               prev = node;
           }
       }
        return root;
    }
}
