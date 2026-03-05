package org.dsa.leetcode.p5;

import org.dsa.util.ListNode;
import org.dsa.util.ListNodeUtil;

public class ReverseLinkedList2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2,new ListNode(3, new ListNode(4,new ListNode(5)))));
        ListNodeUtil.printList(head);
        new ReverseLinkedList2().reverseBetween(head,2,4);
        ListNodeUtil.printList(head);
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
       dummy.next = head;
       ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;
        ListNode next;
        for (int i = 0; i < (right-left); i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }
}
