package org.dsa.leetcode.p3;

import org.utility.TreeNode;

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(new MinimumDepthOfBinaryTree().minDepth(treeNode));
    }
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        // If left child is null, compute depth using right subtree
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        // If right child is null, compute depth using left subtree
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        // If both children are present, take the minimum depth
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));


    }
}
