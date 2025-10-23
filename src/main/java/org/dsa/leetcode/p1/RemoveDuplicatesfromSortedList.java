package org.dsa.leetcode.p1;

import org.dsa.util.ListNode;
import org.dsa.util.ListNodeUtil;

public class RemoveDuplicatesfromSortedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1)));
        ListNodeUtil.printList(head);
        head = new RemoveDuplicatesfromSortedList().deleteDuplicates(head);
        ListNodeUtil.printList(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        //if head is null or head is single listNode
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return head;
    }
}
