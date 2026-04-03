package org.dsa.leetcode.tree;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
    }
    private int sum= 0;
    private int currentSum = 0;
    public int sumNumbers(TreeNode root) {
        sumNumbersHelper(root);
        return sum;
    }

    private void sumNumbersHelper(TreeNode root) {
        if(root == null) return;
        currentSum = currentSum * 10 + root.val;
        if(root.left == null && root.right == null){
            sum +=  currentSum;
            currentSum /= 10;
            return;
        }
        sumNumbersHelper(root.left);
        sumNumbersHelper(root.right);
        currentSum /= 10;
    }
}
