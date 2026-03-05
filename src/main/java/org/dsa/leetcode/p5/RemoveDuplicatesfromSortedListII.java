package org.dsa.leetcode.p5;

import org.dsa.util.ListNode;
import org.dsa.util.ListNodeUtil;

public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4,
//                new ListNode(4, new ListNode(5)))))));
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1,
                new ListNode(1, new ListNode(5)))))));
        ListNodeUtil.printList(head);
        head = new RemoveDuplicatesfromSortedListII().deleteDuplicates(head);
        ListNodeUtil.printList(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode prev = result;
        result.next = head;
        while (head != null) {
            if(head.next != null && head.val == head.next.val){
                int duplicatevalue = head.val;
                while(head != null && head.val == duplicatevalue){
                    head = head.next;
                }
                prev.next = head;
            }else{
                prev = prev.next;
                head = head.next;
            }
        }
        return result.next;
    }
}
