package org.dsa.leetcode.tree;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(-10,new TreeNode(9),new TreeNode(20, new  TreeNode(15), new TreeNode(7)));
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(treeNode));
    }
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       dfs(root);
       return ans;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftPathMax = Math.max(dfs(root.left), 0);
        int rightPathMax = Math.max(dfs(root.right), 0);
        int currentPath = root.val + leftPathMax + rightPathMax;
        ans = Math.max(ans, currentPath);
        return root.val + Math.max(leftPathMax, rightPathMax);
    }
}
