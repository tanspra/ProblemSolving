package org.dsa.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfshelper(root, 0, res);
        for (int i = 0; i < res.size(); i++) {
            if ((i & 1) == 1) {
                Collections.reverse(res.get(i));
                res.set(i, res.get(i));
            }
        }
        return res;
    }

    private void dfshelper(TreeNode node, int levelindex, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        if (res.size() == levelindex) {
            res.add(new ArrayList<>());
        }
        res.get(levelindex).add(node.val);
        dfshelper(node.left, levelindex + 1, res);
        dfshelper(node.right, levelindex + 1, res);
    }

}
