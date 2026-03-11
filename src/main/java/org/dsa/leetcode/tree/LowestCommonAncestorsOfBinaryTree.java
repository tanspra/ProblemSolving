package org.dsa.leetcode.tree;

public class LowestCommonAncestorsOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode node = new LowestCommonAncestorsOfBinaryTree().lowestCommonAncestor(root,new TreeNode(5), new TreeNode(4));
        System.out.println(node.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       TreeNode ans = new TreeNode(Integer.MAX_VALUE);
       getBoss(root, p,q,ans);
       return ans;
    }
    private int getBoss(TreeNode root, TreeNode p, TreeNode q, TreeNode ans) {
        if(root == null) return 0;
        int left = getBoss(root.left,p,q,ans);
        int right = getBoss(root.right,p,q,ans);
        int self = 0;
        if(root.val == p.val || root.val == q.val) {
            self = 1;
        };
       int count = left + right + self;
       if(count == 2 && ans.val == Integer.MAX_VALUE){
           ans.val = root.val;
       }
       return count;
    }
}
