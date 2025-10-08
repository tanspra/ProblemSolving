package org.dsa.leetcode.p3;

import org.dsa.util.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        if(temp == null){
            return temp;
        }
        ListNode newHead = temp;
        temp = temp.next;
        newHead.next = null;
        while(temp != null){
            ListNode t = temp;
            temp = temp.next;
            t.next = newHead;
            newHead = t;
        }
        return newHead;
    }
}
