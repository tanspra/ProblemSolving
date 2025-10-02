package org.dsa.leetcode.p3;

import org.utility.TreeNode;

public class PathSum {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(new PathSum().hasPathSum(treeNode, 12));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        //base case if the tree is null
        if (root == null) return false;

        //for leaf node
        if (root.left == null && root.right == null) return targetSum == root.val;

        int remainingSum = targetSum - root.val;

        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}
