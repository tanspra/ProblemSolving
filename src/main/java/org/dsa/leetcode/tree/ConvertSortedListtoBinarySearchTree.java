package org.dsa.leetcode.tree;

import org.dsa.util.ListNode;

public class ConvertSortedListtoBinarySearchTree {
    public static void main(String[] args) {
        ListNode head = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
        TreeNode treeNode = new ConvertSortedListtoBinarySearchTree().sortedListToBST(head);
        System.out.println(treeNode);
    }
    private ListNode current = null;
    public TreeNode sortedListToBST(ListNode head) {
        current = head;
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return buildBST(0, size-1);
    }

    private TreeNode buildBST(int left, int right) {
        if(left > right){
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode leftSubtree = buildBST(left, mid-1);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        root.left = leftSubtree;
        root.right = buildBST(mid+1, right);
        return root;
    }

    public TreeNode sortedListToBST2(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode temp = middleNode(head);
        TreeNode root = new TreeNode(temp.val);
        root.left = sortedListToBST2(head);
        root.right = sortedListToBST2(temp.next);
        return root;
    }

    private ListNode middleNode(ListNode node) {
        if(node.next == null) return node;
        if(node.next.next == null) {
            ListNode temp = node.next;
            node.next = null;
            return temp;
        }
        ListNode fast = node;
        ListNode slow = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = node;
        while(temp.next != slow)
            temp = temp.next;
        temp.next = null;
        return slow;
    }
}
