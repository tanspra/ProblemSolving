package org.dsa.leetcode.p1;


import org.dsa.util.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return bstHelper(nums, 0, nums.length - 1);
    }

    private TreeNode bstHelper(int[] nums, int left, int right) {
        if (left < right) return null;
        int mid = left + (right - left) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = bstHelper(nums, left, mid - 1);
        treeNode.right = bstHelper(nums, mid + 1, right);
        return treeNode;
    }
}
