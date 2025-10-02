package org.dsa.leetcode.p3;

import org.utility.ListNode;

/*https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
19. Remove Nth Node From End of List
Medium
Topics
Companies
Hint
Given the head of a linked list, remove the nth node from the end of the list and return its head.



Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

* */
public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(listNode);
        //     System.out.println( new RemoveNthNodeFromEnd().removeNthFromEnd(listNode,1));
//        System.out.println( new RemoveNthNodeFromEnd().removeNthFromEnd(listNode,2));
//        System.out.println( new RemoveNthNodeFromEnd().removeNthFromEnd(listNode,3));
        //       System.out.println( new RemoveNthNodeFromEnd().removeNthFromEnd(listNode,4));
        System.out.println(new RemoveNthNodeFromEnd().removeNthFromEnd(listNode, 5));


    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        ListNode temp1 = head;
        for (int i = 1; i < (length - n); i++) {
            temp1 = temp1.next;
        }
        if (length == n) {
            head = head.next;
        } else if (temp1.next == null) {
            return null;
        } else {
            temp1.next = temp1.next.next;
        }
        return head;
    }


}

