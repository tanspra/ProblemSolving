package org.dsa.leetcode.p4;

import org.utility.ListNode;

//https://leetcode.com/problems/reverse-nodes-in-k-group/description/
public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        System.out.println(new ReverseNodesInKGroup().reverseKGroup(new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(4,
                        new ListNode(5))))), 2));

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        int count = 0;

        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        temp =dummy;
        while (temp.next != null) {
            if (count < k) break;
            ListNode tempNext = temp.next;
            ListNode first = temp.next;
            ListNode second = first.next;

            int nodes = k-1;

            while (nodes-- > 0) {
                ListNode next = second.next;
                second.next = first;
                first = second;
                second = next;
            }
            count -= k;
            temp.next = first;
            tempNext.next = second;
            temp = tempNext;
        }
        return dummy.next;
    }
}
