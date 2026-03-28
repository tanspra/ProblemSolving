package org.dsa.leetcode.tree;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }

    private int ans = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return ans;
    }
    private int getHeight(TreeNode root){
        if(root==null){ return 0;}
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        ans = Math.max(ans,left+right);
        return Math.max(left,right)+1;
    }
}
