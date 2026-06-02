package org.dsa.leetcode.tree;


import org.dsa.util.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node result = new PopulatingNextRightPointersinEachNode().connect(root);
        System.out.println(result.val);
    }

    public Node connect(Node root) {
        if(root == null) return root;
        Node leftMost = root;

        while(leftMost.left != null) {
            Node head = leftMost;
            while(head != null){
                head.left.next = head.right;
                if(head.next != null){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }


    public Node connect2(Node root) {
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node currNode = pair.node;
            int currLevel = pair.level;
            if (currNode != null && currNode.next == null) {
                if (queue.size() > 0 && queue.peek().level == currLevel) {
                    currNode.next = queue.peek().node;
                }
                if (currNode.left != null && currNode.right != null) {
                    queue.offer(new Pair(currNode.left, currLevel + 1));
                    queue.offer(new Pair(currNode.right, currLevel + 1));
                }
            }
        }
        return root;
    }

    private record Pair(Node node, int level) {
    }
}
