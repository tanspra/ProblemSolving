package org.leetcode;

import org.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.left.left = new TreeNode(2);
        treeNode.right.right = new TreeNode(4);
        System.out.println(new PathSum2().pathSum(treeNode, 12));
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumHelper(root, targetSum, result, new ArrayList<>());
        return result;
    }

    private void pathSumHelper(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> currentPath) {
        //base case if the tree is null
        if (root == null) return;

        currentPath.add(root.val);
        //for leaf node
        if (root.left == null && root.right == null) {
            if(targetSum == root.val) {
                result.add(new ArrayList<>(currentPath));
                currentPath.remove(currentPath.size() - 1);
                return;
            }
        }

        int remainingSum = targetSum - root.val;
        pathSumHelper(root.left, remainingSum, result, currentPath);
        pathSumHelper(root.right, remainingSum, result, currentPath);
        currentPath.remove(currentPath.size() - 1);
    }
}
