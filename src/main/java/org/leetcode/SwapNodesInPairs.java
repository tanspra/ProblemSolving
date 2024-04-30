package org.leetcode;

//https://leetcode.com/problems/swap-nodes-in-pairs/description/
public class SwapNodesInPairs {
    public static void main(String[] args) {
        System.out.println(new SwapNodesInPairs().swapPairs(new ListNode(1,new ListNode(2))));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {

            return head;
        }
        ListNode temp = head;
        if(head.next != null){
           int val = temp.next.val;
           temp.next.val = temp.val;
           temp.val = val;
           temp = temp.next.next;
        }
        while(temp != null && null != temp.next ){
            int val = temp.next.val;
            temp.next.val = temp.val;
            temp.val = val;
            temp = temp.next.next;
            if(temp == null){
                break;
            }
        }

        return head;
    }
}
