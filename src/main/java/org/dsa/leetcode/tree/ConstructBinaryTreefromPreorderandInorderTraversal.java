package org.dsa.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    private Map<Integer, Integer> map = new HashMap<>();
    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, inorder.length-1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int low, int high) {
        if (low > high) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[index++]);
        int id = map.get(node.val);
        node.left = buildTreeHelper(preorder, low, id - 1);
        node.right = buildTreeHelper(preorder, id + 1, high);
        return node;
    }

}
