package org.dsa.leetcode.p1;


import org.dsa.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,null,new TreeNode(5)),new TreeNode(3));
        List<String> strings = new BinaryTreePaths().binaryTreePaths(root);
        System.out.println(strings);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        pathHelper(root, list,"");
        return list;
    }
    private void pathHelper(TreeNode node, List<String> res, String path){
        if(node == null) return;
        path += Integer.toString(node.val);
        if(node.left == null && node.right ==null){
            res.add(path);
        }else {
            path += "->";
            pathHelper(node.left,res,path);
            pathHelper(node.right,res,path);
        }
    }
}
