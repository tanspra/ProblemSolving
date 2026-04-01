package org.dsa.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree {
    public static void main(String[] args) {

    }

    public boolean isCompleteTree(TreeNode root) {
        boolean nullSeen = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                nullSeen = true;
            } else {
                if(nullSeen){
                    return false;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return true;
    }
}
