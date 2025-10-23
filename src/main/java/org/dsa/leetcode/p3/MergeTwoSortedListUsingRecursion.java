package org.dsa.leetcode.p3;

import org.dsa.util.ListNode;

/*https://leetcode.com/problems/merge-two-sorted-lists/description/
* 21. Merge Two Sorted Lists
Easy
Topics
Companies
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.



Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
* */
public class MergeTwoSortedListUsingRecursion {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(6))));
        System.out.println(new MergeTwoSortedListUsingRecursion().mergeTwoLists(listNode1, listNode2));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if(list1 == null || list2 == null){
        return (list1 != null) ? list1 : list2;
    }
    if(list2.val < list1.val ){
        ListNode temp = list1;
        list1 = list2;
        list2 = temp;

    }

    list1.next = mergeTwoLists(list1.next,list2);
    return list1;
    }
}
