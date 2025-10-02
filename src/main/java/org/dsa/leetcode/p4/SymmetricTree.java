package org.dsa.leetcode.p4;

import org.utility.TreeNode;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(2);
        System.out.println(new SymmetricTree().isSymmetric(treeNode));
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;

        if(left == null || right == null)return false;

        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);

    }
}
