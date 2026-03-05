package org.dsa.leetcode.p1;

import org.dsa.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderHelper(root, res);
        return res;
    }

    private void postorderHelper(TreeNode treeNode, List<Integer> res ){
        if (treeNode == null) {
            return;
        }
        postorderHelper(treeNode.left, res);
        postorderHelper(treeNode.right, res);
        res.add(treeNode.val);
    }
}
