package org.leetcode;

import java.util.Arrays;

/*https://leetcode.com/problems/merge-k-sorted-lists/description/
 * */
public class MergeKSortedList {
    public static void main(String[] args) {
        System.out.println(new MergeKSortedList().mergeKLists(new ListNode[]{new ListNode(1, new ListNode(4, new ListNode(5))), new ListNode(1, new ListNode(3, new ListNode(4))), new ListNode(2, new ListNode(6))}));

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode resultNode = new ListNode();
        ListNode temp = resultNode;
        int length = 0;
        for (ListNode listNode : lists) {
            while (listNode != null) {
                listNode = listNode.next;
                length++;
            }
        }
        int[] arr = new int[length];
        int index = 0;
        for (ListNode listNode : lists) {
            while (listNode != null) {
                arr[index] = listNode.val;
                listNode = listNode.next;
                index++;
            }
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return resultNode.next;
    }

}
