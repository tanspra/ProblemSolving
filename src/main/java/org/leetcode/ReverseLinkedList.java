package org.leetcode;

import org.utility.ListNode;

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
