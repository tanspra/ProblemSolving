package org.leetcode;

import org.utility.GraphUtil;
import org.utility.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        GraphUtil.printTree(root);
        new FlattenBinaryTreeToLinkedList().flatten(root);
        GraphUtil.printTree(root);

    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode tempRight = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }

        current.right = tempRight;
    }
}
