package org.dsa.leetcode.tree;

public class ValidateBST {
    private TreeNode prev = null;
    private boolean ans = true;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0, new TreeNode(-1), null);
        System.out.println(new ValidateBST().isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        bstHelper(root);
        return ans;
    }

    private void bstHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        bstHelper(root.left);
        if (prev == null) {
            prev = root;
        } else {
            if (root.val <= prev.val) {
                ans = false;
            }
            prev = root;
        }
        bstHelper(root.right);
    }
}
