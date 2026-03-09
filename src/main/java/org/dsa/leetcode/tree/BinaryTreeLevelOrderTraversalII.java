package org.dsa.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, ans, 0);
        Collections.reverse(ans);
        return ans;
    }
    private void helper(TreeNode root, List<List<Integer>> ans, int level){
        if(root == null) return;
        if(ans.size() == level) ans.add(new ArrayList<>());
        ans.get(level).add(root.val);
        helper(root.left, ans, level+1);
        helper(root.right, ans, level+1);
    }
}
