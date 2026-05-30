package org.dsa.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    private final Map<Integer, Integer> map = new HashMap<>();
    private int index = 0;

    public static void main(String[] args) {
        int[] inorder = new int[]{3, 9, 20, 15, 7};
        int[] postorder = new int[]{9, 3, 15, 20, 7};
        new ConstructBinaryTreefromInorderandPostorderTraversal().buildTree(inorder, postorder);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(postorder,0,inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] postorder, int low, int high) {
        if (low > high) return null;
        TreeNode root = new TreeNode(postorder[index--]);
        int id = map.get(root.val);
        root.right = buildTreeHelper(postorder, id + 1, high);
        root.left = buildTreeHelper(postorder, low, id - 1);
        return root;
    }

}
