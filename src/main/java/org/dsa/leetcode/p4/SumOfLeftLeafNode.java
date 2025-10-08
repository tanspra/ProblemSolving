package org.dsa.leetcode.p4;

import org.dsa.util.TreeNode;

public class SumOfLeftLeafNode {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if(root == null){
            return 0;
        }
        if(isLeaf(root.left)){
            sum += root.left.val;
        }else{
            sum += sumOfLeftLeaves(root.left);
        }
        sum+= sumOfLeftLeaves(root.right);
        return sum;
    }
    private boolean isLeaf(TreeNode node){
        return node != null && node.left == null && node.right == null;
    }
}
