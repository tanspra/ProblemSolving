package org.leetcode;

import org.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        treeNode.right = node1;
        node1.left = new TreeNode(3);
        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(treeNode));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root != null && root.left != null) {
            inorder(root.left, res);
        }
        if (root != null) {
            res.add(root.val);
        }
        if (root != null && root.right != null) {
            inorder(root.right, res);
        }
    }
}
