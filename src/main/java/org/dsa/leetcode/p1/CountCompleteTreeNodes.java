package org.dsa.leetcode.p1;


import org.dsa.util.TreeNode;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
    if(root == null){
        return 0;
    }
    return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
