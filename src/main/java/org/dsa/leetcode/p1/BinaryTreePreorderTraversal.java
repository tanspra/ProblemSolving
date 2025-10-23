package org.dsa.leetcode.p1;

import org.dsa.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderHelper(root, res);
        return res;
    }

    private void preorderHelper(TreeNode treeNode, List<Integer> res ){
        if (treeNode == null) {
            return;
        }
        res.add(treeNode.val);
        preorderHelper(treeNode.left, res);
        preorderHelper(treeNode.right, res);
    }
}
