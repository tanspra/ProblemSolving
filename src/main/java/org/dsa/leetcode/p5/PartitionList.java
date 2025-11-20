package org.dsa.leetcode.p5;

import org.dsa.util.ListNode;
import org.dsa.util.ListNodeUtil;

public class PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        ListNodeUtil.printList(head);
        head= new PartitionList().partition(head, 3);
        ListNodeUtil.printList(head);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode();
        ListNode dummyTail = new ListNode();
        ListNode dummyHeadTemp = dummyHead;
        ListNode dummyTailTemp = dummyTail;
        while (head != null) {
            if (head.val < x) {
                ListNode temp = new ListNode(head.val);
                dummyHeadTemp.next = temp;
                dummyHeadTemp = dummyHeadTemp.next;
            } else {
                ListNode temp = new ListNode(head.val);
                dummyTailTemp.next = temp;
                dummyTailTemp = dummyTailTemp.next;
            }
            head = head.next;
        }
        dummyHeadTemp.next = dummyTail.next;
        return dummyHead.next;
    }
}
