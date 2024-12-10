package org.leetcode;

import org.utility.TreeNode;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        treeNode.right = node1;
        node1.left = new TreeNode(3);
        System.out.println(new ValidateBinarySearchTree().isValidBST(treeNode));
    }

    public boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);
    }

    private boolean validateBST(TreeNode root, Integer min, Integer max) {
        //base case , if root is null then return true
        if (root == null) return true;

        //check the value in range
        if ((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;

        //recursivey check for left subtree and right subtree
        return validateBST(root.left, min, root.val) && validateBST(root.right, root.val, max);
    }
}
