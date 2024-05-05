package org.leetcode;

//https://leetcode.com/problems/swap-nodes-in-pairs/description/
public class SwapNodesInPairs {
    public static void main(String[] args) {
//        System.out.println(new SwapNodesInPairs().swapPairs(new ListNode(1,new ListNode(2))));
        System.out.println(new SwapNodesInPairs().swapPairs(new ListNode(1,new ListNode(2,
                new ListNode(3)))));
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head != null && head.next != null ? head.next : head;
        ListNode start = new ListNode(-1);
        start.next = head;
        //start.next = head;
        while(start!=null && start.next != null && start.next.next != null) {
            ListNode swap1 = start.next;
            ListNode swap2 = start.next.next;
            swap1.next = swap2.next;
            swap2.next = swap1;
            start.next = swap2;
            start = start.next.next;
        }
        return next;
    }
    public ListNode swapPairs1(ListNode head) {
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

    public ListNode swapPairs2(ListNode head) {
        ListNode node  = head;
        ListNode next = head != null && head.next != null ? head.next : head;
        ListNode prev = null;
        while (node != null) {
            if (node.next != null) {
                if (prev != null)
                    prev.next = node.next;
                prev = node;
                ListNode list = node.next.next;
                node.next.next = node;
                node.next = list;
                node = list;
            }
            else
                node = null;
        }
        return next;
    }
}
