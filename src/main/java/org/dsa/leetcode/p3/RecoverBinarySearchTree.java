package org.dsa.leetcode.p3;

import org.dsa.util.GraphUtil;
import org.dsa.util.TreeNode;

public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(2);

        GraphUtil.printTree(treeNode);
        new RecoverBinarySearchTree().recoverTree(treeNode);
        GraphUtil.printTree(treeNode);
    }
    TreeNode first = null,second = null, prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        findSwappedNodes(root);

        if(first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void findSwappedNodes(TreeNode node) {
        if(node == null)
            return;

        findSwappedNodes(node.left);

        if(first == null && prev.val > node.val){
            first = prev;
        }
        if(first != null && prev.val > node.val){
            second = node;
        }
        prev = node;
        findSwappedNodes(node.right);
    }
}
