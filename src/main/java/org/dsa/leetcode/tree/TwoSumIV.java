package org.dsa.leetcode.tree;

import java.util.Stack;

public class TwoSumIV {
    private final Stack<TreeNode> asc = new Stack<>();
    private final Stack<TreeNode> desc = new Stack<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        TreeNode temp = root;
        while (temp != null) {
            desc.add(temp);
            temp = temp.left;
        }
        temp = root;
        while (temp != null) {
            asc.add(temp);
            temp = temp.right;
        }
        TreeNode i = getSmallest();
        TreeNode j = getBiggest();
        while (i != null && j != null && i.val != j.val && i.val <= j.val) {
            int sum = i.val + j.val;
            if (sum == k)
                return true;
            else if (sum < k) {
                i = getSmallest();
            } else {
                j = getBiggest();
            }
        }
        return false;
    }

    private TreeNode getBiggest() {
        if (asc.isEmpty()) {
            return null;
        }
        TreeNode biggest = asc.pop();
        TreeNode left = biggest.left;
        while (left != null) {
            asc.add(left);
            left = left.right;
        }
        return biggest;
    }

    private TreeNode getSmallest() {
        if (desc.isEmpty()) {
            return null;
        }
        TreeNode smallest = desc.pop();
        TreeNode right = smallest.right;
        while (right != null) {
            desc.add(right);
            right = right.left;
        }
        return smallest;
    }

}
